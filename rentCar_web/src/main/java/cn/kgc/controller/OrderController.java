package cn.kgc.controller;

import cn.kgc.pojo.*;
import cn.kgc.service.OrderService;
import cn.kgc.service.UserService;
import cn.kgc.utils.AlipayConfig;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private OrderService orderService;
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
//获取所有订单数据
    @RequestMapping(value="/findAll" ,produces = "text/plain;charset=utf-8")
    private String findAll(){
        List<Object> list = new ArrayList<>();
        List<Order> all = orderService.findAll();
        for (Order order:all) {
            List<Object> data = new ArrayList<>();
            User user = orderService.findByIdUser((int) order.getUserid());
            Car car = orderService.findByIdCar((int) order.getCarid());
            Shop shop = orderService.findByIdShop((int) car.getShopid());
            Comment comment = orderService.findByIdComment((int)order.getOid());
            data.add(order);
            data.add(user);
            data.add(car);
            data.add(shop);
            data.add(comment);
            list.add(data);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    //获取某用户所有订单数据
    @RequestMapping(value="/findAllByUserTelNo" ,produces = "text/plain;charset=utf-8")
    private String findAllById(String tel){
        List<Object> list = new ArrayList<>();
        Integer id = userService.findUserIdByTelNo(tel);
        List<Order> all = orderService.findAllByUserId(id);
        for (Order order:all) {
            List<Object> data = new ArrayList<>();
            User user = orderService.findByIdUser((int) order.getUserid());
            Car car = orderService.findByIdCar((int) order.getCarid());
            Shop shop = orderService.findByIdShop((int) car.getShopid());
            Comment comment = orderService.findByIdComment((int)order.getOid());
            data.add(order);
            data.add(user);
            data.add(car);
            data.add(shop);
            data.add(comment);
            list.add(data);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
//    获取某订单详细信息
    @RequestMapping(value="/findById" ,produces = "text/plain;charset=utf-8")
    public String findById(Integer id){
        List<Object> all = new ArrayList<>();
        Order order = orderService.findById(id);
        User user = orderService.findByIdUser((int) order.getUserid());
        Car car = orderService.findByIdCar((int) order.getCarid());
        Shop shop = orderService.findByIdShop((int) car.getShopid());
        Comment comment = orderService.findByIdComment((int)order.getOid());
        Integer totalComment = orderService.findAllCommentNum();
        all.add(order);
        all.add(user);
        all.add(car);
        all.add(shop);
        all.add(comment);
        all.add(totalComment);
        return JSONArray.fromObject(all).toString();
    }
//    添加一个订单
    @RequestMapping(value = "/addOneOrder",produces = "text/plain;charset=utf-8")
    public String addOneOrder(Order order){
        try {
            orderService.addOneOrder(order);
        }catch (Exception e){
            return "{message:failure}";
        }
        return "{message:success}";
    }

//    @Test
//    public void test(){
//        System.out.println((new Random().nextFloat()*12345678+10000000));
//    }
//    支付订单后获取订单详情
    @RequestMapping(value="/payOrder" ,produces = "text/plain;charset=utf-8")
    private String payOrder(Integer id,Integer money){
        List<Object> all = new ArrayList<>();
        Order order = orderService.findById(id);
        User user = orderService.findByIdUser((int) order.getUserid());
        //改变用户金额
//        userService.changeMoney((int)user.getRechargeMoney()+money,(int)user.getUid());
        //改变劵状态,积分不变
        userService.pay((int)user.getUid(),(int)user.getDriverTickets()-money,(int)user.getPoints());
        //改变订单状态以及支付状态
        orderService.changeOrderStatus(id);
        Car car = orderService.findByIdCar((int) order.getCarid());
        Shop shop = orderService.findByIdShop((int) car.getShopid());
        Comment comment = orderService.findByIdComment((int)order.getOid());
        Integer totalComment = orderService.findAllCommentNum();
        all.add(order);
        all.add(user);
        all.add(car);
        all.add(shop);
        all.add(comment);
        all.add("{totalComment:"+totalComment+"}");
        JSONArray jsonArray = JSONArray.fromObject(all);
        return jsonArray.toString();
    }
//    完成后改变订单状态回到订单完成页面
//    @RequestMapping("/findByIdChangeOrderStatus")
//    private ModelAndView findByIdChangeOrderStatus(Integer id){
//        ModelAndView modelAndView = new ModelAndView();
//        Order order = orderService.findById(id);
//        User user = orderService.findByIdUser((int) order.getUserid());
//        order.setOrderStatus(1);
//        modelAndView.addObject("order",order);
//        modelAndView.addObject("user",user);
//        modelAndView.setViewName("index.jsp");
//        return modelAndView;
//    }
//    获取未完成订单数据
    @RequestMapping(value="/findUndoneOrder",produces = "text/plain;charset=utf-8")
    private String findUndoneOrder(){
        List<Object> list = new ArrayList<>();
        List<Order> all = orderService.findUndoneOrder();
        for (Order order:all) {
            List<Object> data = new ArrayList<>();
            User user = orderService.findByIdUser((int) order.getUserid());
            Car car = orderService.findByIdCar((int) order.getCarid());
            Shop shop = orderService.findByIdShop((int) car.getShopid());
            Comment comment = orderService.findByIdComment((int)order.getOid());
            Integer totalComment = orderService.findAllCommentNum();
            data.add(order);
            data.add(user);
            data.add(car);
            data.add(shop);
            data.add(comment);
            data.add("{totalComment:"+totalComment+"}");
            list.add(data);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
    //    获取某用户未完成订单数据
    @RequestMapping(value="/findUndoneOrderByTelNo",produces = "text/plain;charset=utf-8")
    private String findUndoneOrderByUserId(String tel){
        List<Object> list = new ArrayList<>();
        Integer id = userService.findUserIdByTelNo(tel);
        List<Order> all = orderService.findUndoneOrderByUserId(id);
        for (Order order:all) {
            List<Object> data = new ArrayList<>();
            User user = orderService.findByIdUser((int) order.getUserid());
            Car car = orderService.findByIdCar((int) order.getCarid());
            Shop shop = orderService.findByIdShop((int) car.getShopid());
            Comment comment = orderService.findByIdComment((int)order.getOid());
            Integer totalComment = orderService.findAllCommentNum();
            data.add(order);
            data.add(user);
            data.add(car);
            data.add(shop);
            data.add(comment);
            data.add("{totalComment:"+totalComment+"}");
            list.add(data);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
    //    获取未评价订单数据
    @RequestMapping(value="/findNotCommentOrder",produces = "text/plain;charset=utf-8")
    private String findNotCommentOrder(){
        List<Object> list = new ArrayList<>();
        List<Order> all = orderService.findNotCommentOrder();
        for (Order order:all) {
            List<Object> data = new ArrayList<>();
            User user = orderService.findByIdUser((int) order.getUserid());
            Car car = orderService.findByIdCar((int) order.getCarid());
            Shop shop = orderService.findByIdShop((int) car.getShopid());
            Comment comment = orderService.findByIdComment((int)order.getOid());
            Integer totalComment = orderService.findAllCommentNum();
            data.add(order);
            data.add(user);
            data.add(car);
            data.add(shop);
            data.add(comment);
            data.add("{totalComment:"+totalComment+"}");
            list.add(data);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
    //    获取某用户未评价订单数据
    @RequestMapping(value="/findNotCommentOrderByTelNo",produces = "text/plain;charset=utf-8")
    private String findNotCommentOrderByUserId(String tel){
        List<Object> list = new ArrayList<>();
        Integer id = userService.findUserIdByTelNo(tel);
        List<Order> orders = orderService.findAllByUserId(id);
        List<Integer> ids = new ArrayList<>();
        for (Order order:orders) {
            ids.add((int)order.getOid());
        }
        List<Order> all = orderService.findNotCommentOrderByUserId(ids);
        for (Order order:all) {
            List<Object> data = new ArrayList<>();
            User user = orderService.findByIdUser((int) order.getUserid());
            Car car = orderService.findByIdCar((int) order.getCarid());
            Shop shop = orderService.findByIdShop((int) car.getShopid());
            Comment comment = orderService.findByIdComment((int)order.getOid());
            Integer totalComment = orderService.findAllCommentNum();
            data.add(order);
            data.add(user);
            data.add(car);
            data.add(shop);
            data.add(comment);
            data.add("{totalComment:"+totalComment+"}");
            list.add(data);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
//    发布评论
    @RequestMapping(value = "/publishComment",produces = "text/plain;charset=utf-8")
    public String publishComment(Integer oid,Comment comment){
        try{
            orderService.publishComment(oid,comment);
        }catch (Exception e){
            e.printStackTrace();
            return "{message:failure}";
        }
        return "{message:success}";
    }

//    充值页面
    @RequestMapping(value="/pay",produces = "text/plain;charset=utf-8")
    public String pay(Integer id,Integer driverTickets,Integer points){
        User user = userService.findById(id);
        try{
            //改变消费金额
            userService.changeMoney((int)user.getRechargeMoney()+driverTickets,id);
            //改变劵状态,以及积分
            userService.pay(id,(int)user.getDriverTickets()+driverTickets,(int)user.getPoints()+points);
        }catch (Exception e){
            e.printStackTrace();
            return "{message:failure}";
        }
        return "{message:success}";
    }

//预约页面
    @RequestMapping(value = "/findAllComment",produces = "text/plain;charset=utf-8")
    public String findAllComment(Integer id){
        List<Object> list = new ArrayList<>();
        Car car = orderService.findByIdCar(id);
        Shop shop = orderService.findByIdShop((int) car.getShopid());
        List<Comment> comments = orderService.findAllComment();
        List<User> users = new ArrayList<>();
        for (Comment comment:comments) {
            Order order = orderService.findById((int) comment.getId());
            users.add(userService.findById((int)order.getUserid()));
        }
        list.add(car);
        list.add(shop);
        list.add(comments);
        list.add(users);
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }


    @RequestMapping(value="/goAlipay", produces="text/html; charset=UTF-8")
    @ResponseBody
    public String goAlipay(String ordernum,String ordername,Integer ordermoney) throws Exception {

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                                    AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
                                    AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，不可重复，商户网站订单系统中唯一订单号，必填
//        String out_trade_no = ordernum;
        //付款金额，必填
//        String total_amount = ordermoney;
        //订单名称，必填
//        String subject = ordername;
        //商品描述，可空
        String body = "用户订购商品个数：" + "1";
        // 该笔订单允许的最晚付款时间，逾期将关闭交易。
        // 取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点， 如 1.5h不接受，可转换为 90m。
        String timeout_express = "1c";
        // 设置请求的具体内容
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ ordernum +"\","
                + "\"total_amount\":\""+ ordermoney +"\","
                + "\"subject\":\""+ ordername +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println(new String(result.getBytes("ISO-8859-1"),"utf-8"));
        return new String(result.getBytes("ISO-8859-1"),"utf-8");
    }

}

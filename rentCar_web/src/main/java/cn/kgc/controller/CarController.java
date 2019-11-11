package cn.kgc.controller;

import cn.kgc.pojo.Car;
import cn.kgc.pojo.User;
import cn.kgc.service.CarService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//response.setHeader("Access-Control-Allow-Origin", "*");
//Access-Control-Allow-Origin这个Header在W3C标准里用来检查该跨域请求是否可以被通过，
//如果值为*则表明当前页面可以跨域访问。默认的情况下是不允许的

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {
    private CarService carService;
    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Car> cars = carService.findAll();
        modelAndView.addObject("cars",cars);
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }
//    后台登录
    @RequestMapping(value = "/login",produces = "text/plain;charset=utf-8")
    public String login(String name,String password){
        User user = carService.login(name,password);
        return JSONObject.fromObject(user).toString();
    }

//    首页获取车辆管理分页数据
    @RequestMapping(value = "/getCars",produces = "text/plain;charset=utf-8")
    public String getCars(Integer currentPage,Integer pageSize){
        if(currentPage==null){
            currentPage=1;
        }
        if(pageSize==null){
            pageSize=10;
        }
        List<Object> list = new ArrayList<>();
        List<Car> cars = carService.getSectionCars(currentPage-1,pageSize);
        Integer pageCount=carService.getAllCount();
        list.add(cars);
        list.add("{pageSize:"+Math.ceil(1.0*pageCount/pageSize)+"}");
        list.add("{currentPage:"+currentPage+"}");
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
//    首页通过车型查询数据
    @RequestMapping(value = "/getCarsByCarName",produces = "text/plain;charset=utf-8")
    public String getCarsByCarName(String carName){
        List<Car> list = carService.findByCarName(carName);
        return JSONArray.fromObject(list).toString();
    }
//    首页通过车牌号查询数据
    @RequestMapping(value = "/getCarsByCarNum",produces = "text/plain;charset=utf-8")
    public String getCarsByCarNum(String carNum){
        Car car = carService.findByCarNum(carNum);
        return JSONObject.fromObject(car).toString();
    }
//    车辆管理通过车牌号查询数据
    @RequestMapping(value = "/getCarsByCarNumAndOne",produces = "text/plain;charset=utf-8")
    public String getCarsByCarNumAndOne(String carNum){
        List<Object> list = new ArrayList<>();
//        获取通过车牌号查询的单独一个数据
        Car car = carService.findByCarNum(carNum);
        List<Car> cars = carService.getSectionCars(0,6);
        Integer pageCount=carService.getAllCount();
        list.add(car);
        list.add(cars);
        list.add("{pageSize:"+Math.ceil(1.0*(pageCount-6)/10)+"}");
        list.add("{currentPage:"+1+"}");
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }





    @RequestMapping("/save")
    private String save(Car car){
        carService.save(car);
        return "redirect:/car/getSectionCars";
    }
    @RequestMapping("/delete")
    private String delete(Integer[] ids){
        carService.delete(ids);
        return "redirect:/car/getSectionCars";
    }
    @RequestMapping("/update")
    private String update(Car car){
        carService.update(car);
        return "redirect:/car/getSectionCars";
    }
    @RequestMapping("/updateUI")
    private ModelAndView updateUI(Integer ids){
        ModelAndView modelAndView = new ModelAndView();
        Car car = carService.updateUI(ids);
        modelAndView.addObject("car",car);
        modelAndView.setViewName("/pages/car-update.jsp");
        return modelAndView;
    }

}

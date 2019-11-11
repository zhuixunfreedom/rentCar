package cn.kgc.dao.impl;

import cn.kgc.dao.OrderDao;
import cn.kgc.pojo.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderDaoImpl implements OrderDao {

    private SqlSession sqlSession;
    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Order findById(Integer id) {
        return sqlSession.selectOne("findByIdOrder",id);
    }

    @Override
    public User findByIdUser(Integer id) {
        return sqlSession.selectOne("findByIdUser",id);
    }

    @Override
    public Shop findByIdShop(Integer id) {
        return sqlSession.selectOne("findByIdShop",id);
    }

    @Override
    public Car findByIdCar(Integer id) {
        return sqlSession.selectOne("findByIdCar",id);
    }

    @Override
    public List<Car> findByIdListCar(Integer id) {
        return sqlSession.selectList("findByIdCar",id);
    }

    @Override
    public List<Order> findUndoneOrder() {
        return sqlSession.selectList("findUndoneOrder");
    }

    @Override
    public List<Order> findNotCommentOrder() {
        List<Order> list = new ArrayList<>();
        List<Integer> ids = sqlSession.selectList("findNotCommentOrder");
        for (Integer id:ids) {
            list.add((Order) sqlSession.selectOne("findByIdOrder",id));
        }
        return list;
    }

    @Override
    public List<Order> findAll() {
        return sqlSession.selectList("findAllOrder");
    }

    @Override
    public void changeOrderStatus(Integer id) {
        sqlSession.update("changeOrderStatus",id);
    }

    @Override
    public Comment findByIdComment(int id) {
        return sqlSession.selectOne("findByIdComment",id);
    }

    @Override
    public void publishComment(Integer oid,Comment comment) {
        Map<String, Object> map = new HashMap<>();
        map.put("oid",oid);
        map.put("carPoint",comment.getCarPoint());
        map.put("qualityPoint",comment.getQualityPoint());
        map.put("attitudePoint",comment.getAttitudePoint());
        map.put("comment",comment.getComment());
        map.put("commentImg",comment.getCommentImg());
        sqlSession.insert("publishComment",map);
    }

    @Override
    public Integer findAllCommentNum() {
        return sqlSession.selectOne("findAllCommentNum");
    }

    @Override
    public List<Comment> findAllComment() {
        return sqlSession.selectList("findAllComment");
    }

    @Override
    public List<Order> findAllByUserId(Integer id) {
        return sqlSession.selectList("findAllByUserId",id);
    }

    @Override
    public List<Order> findUndoneOrderByUserId(Integer id) {
        return sqlSession.selectList("findUndoneOrderByUserId",id);
    }

    @Override
    public List<Order> findNotCommentOrderByUserId(List<Integer> ids) {
        List<Order> all = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (Integer id:ids) {
            Integer orderid = sqlSession.selectOne("findNotCommentOrderByUserId", id);
            if(orderid != null){
                list.add(orderid);
            }
        }
        for (Integer id:list) {
            Order order = sqlSession.selectOne("findByIdOrder", id);
            all.add(order);
        }

        return all;
    }

    @Override
    public void addOneOrder(Order order) {
        System.out.println(order);
        Map<String, Object> map = new HashMap<>();
        map.put("getCarAddress",order.getGetCarAddress());
        map.put("returnCarAddress",order.getReturnCarAddress());
        map.put("getCarTime",order.getGetCarTime());
        map.put("returnCarTime",order.getReturnCarTime());
        map.put("rentTime",order.getRentTime());
        map.put("rentType",order.getRentType());
        map.put("rentCarName",order.getRentCarName());
        map.put("rentCarNum",order.getRentCarNum());
        map.put("rentMoney",order.getRentMoney());
        map.put("totalMoney",order.getTotalMoney());
        map.put("orderNum",(int)(new Random().nextFloat()*12345678+10000000)+"");
        map.put("rentCity",order.getRentCity());
        map.put("driveLong",(int)order.getDriveLong()+"");
        map.put("userid",order.getUserid());
        map.put("carid",order.getCarid());
        sqlSession.insert("addOneOrder",map);
    }
}

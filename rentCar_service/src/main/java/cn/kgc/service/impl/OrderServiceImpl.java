package cn.kgc.service.impl;

import cn.kgc.dao.OrderDao;
import cn.kgc.pojo.*;
import cn.kgc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order findById(Integer id) {
        return orderDao.findById(id);
    }

    @Override
    public User findByIdUser(Integer id) {
        return orderDao.findByIdUser(id);
    }

    @Override
    public Shop findByIdShop(Integer id) {
        return orderDao.findByIdShop(id);
    }

    @Override
    public Car findByIdCar(Integer id) {
        return orderDao.findByIdCar(id);
    }

    @Override
    public List<Car> findByIdListCar(Integer id) {
        return orderDao.findByIdListCar(id);
    }

    @Override
    public List<Order> findUndoneOrder() {
        return orderDao.findUndoneOrder();
    }

    @Override
    public List<Order> findNotCommentOrder() {
        return orderDao.findNotCommentOrder();
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public void changeOrderStatus(Integer id) {
        orderDao.changeOrderStatus(id);
    }

    @Override
    public Comment findByIdComment(int oid) {
        return orderDao.findByIdComment(oid);
    }

    @Override
    public void publishComment(Integer oid,Comment comment) {
        orderDao.publishComment(oid,comment);
    }

    @Override
    public Integer findAllCommentNum() {
        return orderDao.findAllCommentNum();
    }

    @Override
    public List<Comment> findAllComment() {
        return orderDao.findAllComment();
    }

    @Override
    public List<Order> findAllByUserId(Integer id) {
        return orderDao.findAllByUserId(id);
    }

    @Override
    public List<Order> findUndoneOrderByUserId(Integer id) {
        return orderDao.findUndoneOrderByUserId(id);
    }

    @Override
    public List<Order> findNotCommentOrderByUserId(List<Integer> ids) {
        return orderDao.findNotCommentOrderByUserId(ids);
    }

    @Override
    public void addOneOrder(Order order) {
        orderDao.addOneOrder(order);
    }
}

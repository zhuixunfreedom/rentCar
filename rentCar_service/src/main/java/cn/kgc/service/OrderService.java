package cn.kgc.service;

import cn.kgc.pojo.*;

import java.util.List;

public interface OrderService {
    Order findById(Integer id);
    User findByIdUser(Integer id);
    Shop findByIdShop(Integer id);

    Car findByIdCar(Integer id);

    List<Car> findByIdListCar(Integer id);

    List<Order> findUndoneOrder();

    List<Order> findNotCommentOrder();

    List<Order> findAll();

    void changeOrderStatus(Integer id);

    Comment findByIdComment(int oid);

    void publishComment(Integer oid,Comment comment);

    Integer findAllCommentNum();

    List<Comment> findAllComment();

    List<Order> findAllByUserId(Integer id);

    List<Order> findUndoneOrderByUserId(Integer id);

    List<Order> findNotCommentOrderByUserId(List<Integer> ids);

    void addOneOrder(Order order);
}

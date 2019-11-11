package cn.kgc.service;

import cn.kgc.pojo.User;

public interface UserService {
    void changeMoney(Integer money,Integer uid);

    void pay(Integer id,Integer driverTickets,Integer point);

    User findById(Integer id);

    Integer findUserIdByTelNo(String tel);
}

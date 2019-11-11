package cn.kgc.service.impl;

import cn.kgc.dao.UserDao;
import cn.kgc.pojo.User;
import cn.kgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void changeMoney(Integer money,Integer uid) {
        userDao.changeMoney(money,uid);
    }

    @Override
    public void pay(Integer id,Integer driverTickets,Integer point) {
        userDao.pay(id,driverTickets,point);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public Integer findUserIdByTelNo(String tel) {
        return userDao.findUserIdByTelNo(tel);
    }
}

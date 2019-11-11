package cn.kgc.service.impl;

import cn.kgc.dao.CarDao;
import cn.kgc.pojo.Car;
import cn.kgc.pojo.User;
import cn.kgc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private CarDao carDao;
    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public List<Car> getSectionCars(Integer nowPage,Integer pageNum) {
        return carDao.getSectionCars(nowPage,pageNum);
    }

    @Override
    public Integer getAllCount() {
        return carDao.getAllCount();
    }

    @Override
    public void save(Car car) {
//        jsp不支持绝对路径，会直接找工程下的文件
//        添加图片相对路径+选择的文件名
        car.setCarImg("img/"+car.getCarImg());
        carDao.save(car);
    }

    @Override
    public void delete(Integer[] ids) {
        carDao.delete(ids);
    }

    @Override
    public void update(Car car) {
        car.setCarImg("img/"+car.getCarImg());
        carDao.update(car);
    }

    @Override
    public Car updateUI(Integer id) {
        return carDao.updateUI(id);
    }

    @Override
    public Car findByCarNum(String carNum) {
        return carDao.findBycarNum(carNum);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public User login(String name, String password) {
        return carDao.login(name,password);
    }
}

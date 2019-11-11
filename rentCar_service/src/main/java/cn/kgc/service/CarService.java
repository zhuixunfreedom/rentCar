package cn.kgc.service;

import cn.kgc.pojo.Car;
import cn.kgc.pojo.User;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    List<Car> getSectionCars(Integer nowPage,Integer pageNum);

    Integer getAllCount();

    void save(Car car);

    void delete(Integer[] ids);

    void update(Car car);

    Car updateUI(Integer id);

    Car findByCarNum(String carNum);

    List<Car> findByCarName(String carName);

    User login(String name, String password);
}

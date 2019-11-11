package cn.kgc.dao.impl;

import cn.kgc.dao.CarDao;
import cn.kgc.pojo.Car;
import cn.kgc.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CarDaoImpl implements CarDao {
    private SqlSession sqlSession;
    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Car> findAll() {
        return sqlSession.selectList("findAllCar");
    }

    @Override
    public List<Car> getSectionCars(Integer nowPage,Integer pageNum) {
        Map<String,Integer> map = new HashMap<>();
        map.put("nowPage",nowPage*pageNum);
        map.put("pageNum",pageNum);
        return sqlSession.selectList("getSectionCars",map);
    }

    @Override
    public Integer getAllCount() {
        return sqlSession.selectOne("getCarAllCount");
    }

    @Override
    public void save(Car car) {
        sqlSession.insert("saveCar",car);
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id:ids) {
            sqlSession.delete("deleteCar",id);
        }
    }

    @Override
    public void update(Car car) {
        sqlSession.update("updateCar",car);
    }

    @Override
    public Car updateUI(Integer id) {
        return sqlSession.selectOne("updateCarUI",id);
    }

    @Override
    public Car findBycarNum(String carNum) {
        return sqlSession.selectOne("findByCarNum",carNum);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return sqlSession.selectList("findByCarName",carName);
    }

    @Override
    public User login(String name, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("name",name);
        map.put("password",password);
        return sqlSession.selectOne("login",map);
    }
}

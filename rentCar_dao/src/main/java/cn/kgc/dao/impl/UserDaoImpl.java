package cn.kgc.dao.impl;

import cn.kgc.dao.UserDao;
import cn.kgc.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession;
    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void changeMoney(Integer money,Integer uid) {
        Map<String, Integer> map = new HashMap<>();
        map.put("money",money);
        map.put("uid",uid);
        sqlSession.update("changeMoney",map);
    }

    @Override
    public void pay(Integer id,Integer driverTickets,Integer point) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("id",id);
        map.put("driverTickets",driverTickets);
        map.put("point",point);
        sqlSession.update("pay",map);
    }

    @Override
    public User findById(Integer id) {
        return sqlSession.selectOne("findByIdUser",id);
    }

    @Override
    public Integer findUserIdByTelNo(String tel) {
        return sqlSession.selectOne("findUserIdByTelNo",tel);
    }
}

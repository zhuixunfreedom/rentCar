package cn.kgc.dao.impl;

import cn.kgc.dao.AdministratorDao;
import cn.kgc.pojo.Administrator;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdministratorDaoImpl implements AdministratorDao {

    private SqlSession sqlSession;
    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Administrator findByUsername(String username) {
        return sqlSession.selectOne("findByUsername",username);
    }
}

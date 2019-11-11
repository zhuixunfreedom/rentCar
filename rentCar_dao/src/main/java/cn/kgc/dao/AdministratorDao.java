package cn.kgc.dao;

import cn.kgc.pojo.Administrator;

public interface AdministratorDao {
    Administrator findByUsername(String username);
}

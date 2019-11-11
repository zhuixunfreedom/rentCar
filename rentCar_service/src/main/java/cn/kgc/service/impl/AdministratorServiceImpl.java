package cn.kgc.service.impl;

import cn.kgc.dao.AdministratorDao;
import cn.kgc.pojo.Administrator;
import cn.kgc.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {
    private AdministratorDao administratorDao;
    @Autowired
    public void setUserDao(AdministratorDao administratorDao) {
        this.administratorDao = administratorDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名获取用户对象
        Administrator userAdmin = administratorDao.findByUsername(username);
        if(userAdmin!=null){
            Collection<GrantedAuthority> auther = new ArrayList<>();
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            auther.add(grantedAuthority);
            // 1 用户名   2 密码   角色列表对象
            UserDetails user = new User(userAdmin.getUsername(), "{noop}" + userAdmin.getPassword(), auther);
            return user;
        }
        return null;
    }
}

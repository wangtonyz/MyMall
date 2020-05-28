package com.bistu.MyMall.Service;

import com.bistu.MyMall.Bean.User;
import com.bistu.MyMall.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(String username) {
        return userDao.findByUname(username).get(0);
    }

    public void addUser(User user) {
        userDao.save(user);
    }

}

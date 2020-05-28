package com.bistu.MyMall.Dao;

import com.bistu.MyMall.Bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    List<User> findByUname(String name);

}

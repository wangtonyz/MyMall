package com.bistu.MyMall.Dao;


import com.bistu.MyMall.Bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

    List<Product> findById(int id);

    List<Product> findByUid(int uid);

    void deleteById(int id);


}

package com.bistu.MyMall.Service;

import com.bistu.MyMall.Bean.Product;
import com.bistu.MyMall.Dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public void addProduct(Product product){
        productDao.save(product);
    }

    public void deleteByid(int pid){
        productDao.deleteById(pid);
    }


    public List<Product> findAll(){
        return productDao.findAll();
    }


    public List<Product> findByUserid(int userid) {
        return productDao.findByUid(userid);
    }

    public void updateGood(int id) {
        List<Product> goodslist = productDao.findById(id);
        Product good = goodslist.get(0);
        good.setSold(0);
        productDao.save(good);
    }
}

package com.bistu.MyMall.Controller;

import com.bistu.MyMall.Bean.Product;
import com.bistu.MyMall.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProController {
    @Autowired
    private ProductService goodService;

    //获取全部商品
    @RequestMapping("/listGoods")
    public List<Product> listGoods() throws Exception {
        return goodService.findAll();
    }

    @RequestMapping("/listuserGoods")
    public List<Product> listuserGoods(@RequestParam(value = "userid") String userid) throws Exception {
        return goodService.findByUserid(Integer.parseInt(userid));
    }
    //添加一个商品
    @RequestMapping("/addGood")
    public Boolean addGood(@RequestParam(value = "userid") String userid,
                           @RequestParam(value = "goodname") String goodname,
                           @RequestParam(value = "price") float price,
                           @RequestParam(value = "info") String info,
                           @RequestParam(value = "isbuy") int isbuy) throws Exception {
        try {
            Product good = new Product();
            good.setUid(Integer.parseInt(userid));
            good.setName(goodname);
            good.setPrice(price);
            good.setInfo(info);
            good.setSold(isbuy);
            goodService.addProduct(good);
            System.out.println("userid: " + userid
                    + "\ngoodname: " + goodname
                    + "\nprice: " + price
                    + "info: " + info
                    + "isbuy: " + isbuy + "\n");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //删除一个商品
    @RequestMapping("/deleteGood")
    public Boolean deletGood(@RequestParam(value = "goodid") String goodid){
        int id = Integer.parseInt(goodid);
        System.out.println("goodid: "+id);
        try{
            goodService.deleteByid(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    //商品已卖出
    @RequestMapping("/selloutGood")
    public Boolean selloutGood(@RequestParam(value = "goodid")String goodid){
        int id = Integer.parseInt(goodid);

        try{
            goodService.updateGood(id);
            System.out.println("goodid: "+id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }



}

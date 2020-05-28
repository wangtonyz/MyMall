package com.bistu.MyMall.Bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@ConstructorBinding
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//标注主键，且为自增长型
    @Column(name="pid")
    private int id;
    private float price;
    private String name;
    private int uid;
    private String info;
    private int sold;

    public Product(){}
    public Product(String s1, int s) {
        this.name=s1;
        this.price=s;
    }
}

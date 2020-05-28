package com.bistu.MyMall.Bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Component
@Entity
@Data
@ConstructorBinding
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//标注主键，且为自增长型
    private int uid;
    private String uname;
    private String pwd;
}

package com.heybro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.heybro.mapper")
public class CegAdminUIApplication {

    public static void main(String[] args) {
        SpringApplication.run(CegAdminUIApplication.class, args);
    }
}

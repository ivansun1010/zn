package com.iat.zn.show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//extends SpringBootServletInitializer
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        // Customize the application or call application.sources(...) to add sources
//
//        application.sources(SpringBootMybatisApplication.class);
//        return application;
//    }
}

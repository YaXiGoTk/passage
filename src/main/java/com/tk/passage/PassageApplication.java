package com.tk.passage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.tk.passage.dao")
@SpringBootApplication
public class PassageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassageApplication.class, args);
    }

}

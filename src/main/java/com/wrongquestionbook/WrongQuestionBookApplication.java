package com.wrongquestionbook;

import com.wrongquestionbook.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import javax.annotation.Resource;

@EnableCaching
@SpringBootApplication
public class WrongQuestionBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrongQuestionBookApplication.class, args);
    }

}

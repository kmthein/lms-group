package com.lmsbackend;

import com.lmsbackend.dao.GenreDAO;
import com.lmsbackend.entity.Genre;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LmsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsBackendApplication.class, args);
    }

}

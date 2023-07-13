package com.example.projectceleb;

import com.example.projectceleb.Controller.CelebController;
import com.example.projectceleb.Repository.CelebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Create database*/

@SpringBootApplication
public class ProjectCelebApplication implements CommandLineRunner {
//    @Autowired
//    private CelebRepository celebRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectCelebApplication.class, args);
    }

    @Autowired
    private CelebRepository celebRepository;

    @Override
    public void run(String... args) throws Exception {}



}

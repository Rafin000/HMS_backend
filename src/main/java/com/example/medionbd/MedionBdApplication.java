package com.example.medionbd;

import com.example.medionbd.doctor.Doctor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class MedionBdApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedionBdApplication.class, args);
    }


}

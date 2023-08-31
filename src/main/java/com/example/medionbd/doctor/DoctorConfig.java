package com.example.medionbd.doctor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DoctorConfig {
    @Bean
    CommandLineRunner commandLineRunner(DoctorRepository doctorRepository){
        return args -> {
            Doctor Karim = new Doctor(
                    "mdKarim1998",
                    "01969535853",
                    "Nothing Special",
                    true
            );

            Doctor Mariam = new Doctor(
                    "mariam0034",
                    "01867799139",
                    "Im eye specialist",
                    true
            );

//            doctorRepository.saveAll(List.of(Karim,Mariam));
        };
    }
}

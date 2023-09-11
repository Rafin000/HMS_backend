package com.example.medionbd.controller;

import com.example.medionbd.service.DoctorService;
import com.example.medionbd.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1")
public class DoctorController {
    private final DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }


    @RequestMapping(value = "/doctors/all" , method = RequestMethod.GET)
    public @ResponseBody  List<Doctor> getAllDoctors(){
       return doctorService.getAllDoctors();
    }


    @RequestMapping(value = "/doctor" , method = RequestMethod.POST)
    @ResponseBody
    public void createDoctor(@RequestBody Doctor doctor){
        doctorService.createDoctor(doctor);
    }


    @RequestMapping(value = "/doctors/{doctorId}" , method = RequestMethod.DELETE)
    public  void deleteDoctor(@PathVariable("doctorId") UUID doctorId){
        doctorService.deleteDoctor(doctorId);
    }

    @RequestMapping(value = "/doctors/{doctorId}" , method = RequestMethod.PUT)
    @ResponseBody
    public void updateDoctor(
            @PathVariable("doctorId") UUID doctorId,
            @RequestBody Doctor updatedDoctor
    ){
        doctorService.updateDoctor(doctorId,updatedDoctor);
    }
}

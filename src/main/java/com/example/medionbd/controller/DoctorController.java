package com.example.medionbd.controller;

import com.example.medionbd.dto.DoctorDto;
import com.example.medionbd.service.DoctorService;
import com.example.medionbd.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Doctor> createDoctor(@RequestBody DoctorDto doctorDto){
        Doctor createdDoctor = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/doctors/{doctorId}" , method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteDoctor(@PathVariable("doctorId") UUID doctorId){
        doctorService.deleteDoctor(doctorId);
    }

    @RequestMapping(value = "/doctors/{doctorId}" , method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable("doctorId") UUID doctorId,
            @RequestBody DoctorDto updatedDoctorDto
    ){
        Doctor updatedDoctor= doctorService.updateDoctor(doctorId,updatedDoctorDto);
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }
}

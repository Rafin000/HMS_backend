package com.example.medionbd.doctor;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository ;
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public void createDoctor(Doctor doctor){
        Optional<Doctor> doctorOptional = doctorRepository.findDoctorByUserId(doctor.getUserId());
        if(doctorOptional.isPresent()){
            throw new IllegalStateException("Username Already Taken!");
        }
        doctorRepository.save(doctor);
    }

    public  void deleteDoctor(UUID doctorId){
        boolean exists = doctorRepository.existsById(doctorId);
        if(!exists){
            throw new IllegalStateException("Doctor with Id "+ doctorId+" does not exists");
        }

        doctorRepository.deleteById(doctorId);
    }
    @Transactional
    public  void updateDoctor(UUID doctorId,  Boolean isActive, String biography, String phoneNumber, String userId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new IllegalStateException("Doctor Id with "+ doctorId +" doesn't exists!"));

        if (!Objects.equals(doctor.getActive(),isActive)){
            doctor.setActive(isActive);
        }
        if(!Objects.equals(doctor.getBiography(),biography)){
            doctor.setBiography(biography);
        }

        if (!Objects.equals(doctor.getPhoneNumber(),phoneNumber)) {
            doctor.setPhoneNumber(phoneNumber);
        }

        if(!Objects.equals(doctor.getUserId(),userId)){
            Optional<Doctor> doctorOptional = doctorRepository.findDoctorByUserId(userId);
            if(doctorOptional.isPresent()){
                throw  new IllegalStateException(" Username Already Taken!");
            }

            doctor.setUserId(userId);
        }
    }
}

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
    public  void updateDoctor(UUID doctorId, Doctor updatedDoctor){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new IllegalStateException("Doctor Id with "+ doctorId +" doesn't exists!"));

        if (updatedDoctor.getActive()!=null && !Objects.equals(doctor.getActive(),updatedDoctor.getActive())){
            doctor.setActive(updatedDoctor.getActive());
        }
        if(updatedDoctor.getBiography()!=null && updatedDoctor.getBiography().length()>0 && !Objects.equals(doctor.getBiography(),updatedDoctor.getBiography())){
            doctor.setBiography(updatedDoctor.getBiography());
        }

        if (updatedDoctor.getPhoneNumber() != null && !Objects.equals(doctor.getPhoneNumber(),updatedDoctor.getPhoneNumber())) {
            doctor.setPhoneNumber(doctor.getPhoneNumber());
        }

        if(updatedDoctor.getUserId() !=null && !Objects.equals(doctor.getUserId(),updatedDoctor.getUserId())){
            Optional<Doctor> doctorOptional = doctorRepository.findDoctorByUserId(updatedDoctor.getUserId());
            if(doctorOptional.isPresent()){
                throw  new IllegalStateException(" Username Already Taken!");
            }
            doctor.setUserId(updatedDoctor.getUserId());
        }
    }
}

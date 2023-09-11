package com.example.medionbd.service;

import com.example.medionbd.model.Doctor;
import com.example.medionbd.repository.DoctorRepository;
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

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public void createDoctor(Doctor doctor){
        Optional<Doctor> doctorOptional = doctorRepository.findDoctorByRegistrationId(doctor.getRegistrationId());
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

        if(updatedDoctor.getBiography()!=null && updatedDoctor.getBiography().length()>0 && !Objects.equals(doctor.getBiography(),updatedDoctor.getBiography())){
            doctor.setBiography(updatedDoctor.getBiography());
        }

        if (updatedDoctor.getClinicHour() != null && updatedDoctor.getClinicHour().length()>0 && !Objects.equals(doctor.getClinicHour(),updatedDoctor.getClinicHour())) {
            doctor.setClinicHour(updatedDoctor.getClinicHour());
        }

        if(updatedDoctor.getRegistrationId() !=null && updatedDoctor.getRegistrationId().length()>0 && !Objects.equals(doctor.getRegistrationId(),updatedDoctor.getRegistrationId())){
            Optional<Doctor> doctorOptional = doctorRepository.findDoctorByRegistrationId(updatedDoctor.getRegistrationId());
            if(doctorOptional.isPresent()){
                throw  new IllegalStateException(" Username Already Taken!");
            }
            doctor.setRegistrationId(updatedDoctor.getRegistrationId());
        }
    }
}

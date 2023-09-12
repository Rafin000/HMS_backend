package com.example.medionbd.service;

import com.example.medionbd.dto.DoctorDto;
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

    public Doctor createDoctor(DoctorDto doctorDto){
        Optional<Doctor> doctorOptional = doctorRepository.findDoctorByRegistrationId(doctorDto.getRegistrationId());
        if(doctorOptional.isPresent()){
            throw new IllegalStateException("Username Already Taken!");
        }

        Doctor doctor = new Doctor(
                doctorDto.getRegistrationId(),
                doctorDto.getBiography(),
                doctorDto.getClinicHour()
        );

        doctorRepository.save(doctor);
        return doctor;
    }

    public  void deleteDoctor(UUID doctorId){
        boolean exists = doctorRepository.existsById(doctorId);
        if(!exists){
            throw new IllegalStateException("Doctor with Id "+ doctorId+" does not exists");
        }

        doctorRepository.deleteById(doctorId);
    }
    @Transactional
    public  Doctor updateDoctor(UUID doctorId, DoctorDto updatedDoctorDto){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new IllegalStateException("Doctor Id with "+ doctorId +" doesn't exists!"));

        String updatedRegistrationId = updatedDoctorDto.getRegistrationId();
        String updatedClinicHour = updatedDoctorDto.getClinicHour();
        String updatedBiography = updatedDoctorDto.getBiography();

        if(updatedBiography!=null && updatedBiography.length()>0 && !Objects.equals(doctor.getBiography(),updatedBiography)){
            doctor.setBiography(updatedBiography);
        }

        if (updatedClinicHour != null && updatedClinicHour.length()>0 && !Objects.equals(doctor.getClinicHour(),updatedClinicHour)) {
            doctor.setClinicHour(updatedClinicHour);
        }

        if(updatedRegistrationId !=null && updatedRegistrationId.length()>0 && !Objects.equals(doctor.getRegistrationId(),updatedRegistrationId)){
            Optional<Doctor> doctorOptional = doctorRepository.findDoctorByRegistrationId(updatedRegistrationId);
            if(doctorOptional.isPresent()){
                throw  new IllegalStateException(" Username Already Taken!");
            }
            doctor.setRegistrationId(updatedRegistrationId);
        }
        return doctor;
    }
}

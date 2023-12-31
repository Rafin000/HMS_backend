package com.example.medionbd.repository;

import com.example.medionbd.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    @Query("SELECT d FROM Doctor d WHERE d.registrationId=?1")
    Optional<Doctor> findDoctorByRegistrationId(String registrationId);
}

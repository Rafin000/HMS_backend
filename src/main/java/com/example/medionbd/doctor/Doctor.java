package com.example.medionbd.doctor;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String registrationId;
    private  String clinicHour;
    private  String biography;

    public Doctor() {
    }

    public Doctor(String registrationId, String clinicHour, String biography) {
        this.registrationId = registrationId;
        this.clinicHour = clinicHour;
        this.biography = biography;
    }

    public Doctor(UUID id, String registrationId, String clinicHour, String biography) {
        this.id = id;
        this.registrationId = registrationId;
        this.clinicHour = clinicHour;
        this.biography = biography;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getClinicHour() {
        return clinicHour;
    }

    public void setClinicHour(String clinicHour) {
        this.clinicHour = clinicHour;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", registrationId='" + registrationId + '\'' +
                ", clinicHour='" + clinicHour + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}

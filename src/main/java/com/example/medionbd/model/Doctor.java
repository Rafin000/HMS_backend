package com.example.medionbd.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "Doctor")
@Table(
        name = "doctor",
        uniqueConstraints = {
                @UniqueConstraint(name = "doctor_registration_id_unique", columnNames ="registration_id" )
        }
)

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false
    )
    private UUID id;
    @Column(
            name = "registration_id",
            updatable = true,
            columnDefinition = "TEXT",
            nullable = false
    )
    private String registrationId;
    @Column(
            name = "clinic_hour",
            updatable = true,
            columnDefinition = "TEXT"
    )
    private  String clinicHour;
    @Column(
            name = "biography",
            updatable = true,
            columnDefinition = "TEXT"
    )
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

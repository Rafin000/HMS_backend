package com.example.medionbd.doctor;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String userId;
    private  String phoneNumber;
    private  String biography;
    private Boolean isActive;

    public Doctor() {
    }

    public Doctor(UUID id, String userId, String phoneNumber, String biography, Boolean isActive) {
        this.id = id;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.biography = biography;
        this.isActive = isActive;
    }

    public Doctor(String userId, String phoneNumber, String biography, Boolean isActive) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.biography = biography;
        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", biography='" + biography + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

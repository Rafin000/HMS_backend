package com.example.medionbd.dto;

public class DoctorDto {
    private String registrationId;
    private String clinicHour;
    private String biography;
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

}

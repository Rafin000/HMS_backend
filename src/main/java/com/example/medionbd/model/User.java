package com.example.medionbd.model;

import com.example.medionbd.enums.UserType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "user",
        uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique",columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false
    )
    private UUID id;
    @Column(
            name = "first_name",
            updatable = true,
            columnDefinition = "TEXT",
            nullable = false
    )
    private String firstName;
    @Column(
            name = "last_name",
            updatable = true,
            columnDefinition = "TEXT",
            nullable = false
    )
    private  String lastName;
    @Column(
            name = "email",
            updatable = true,
            columnDefinition = "TEXT",
            nullable = false
    )

    private String email;
    @Column(
            name = "password",
            updatable = true,
            columnDefinition = "TEXT",
            nullable = false
    )
    private String password;
    @Column(
            name = "phone_number",
            updatable = true,
            columnDefinition = "TEXT"
    )
    private String phoneNumber;
    @Enumerated(EnumType.ORDINAL)
    @Column(
            name = "user_type",
            updatable = false,
            nullable = false
    )
    private UserType userType;
    @Column(
            name = "date_of_birth",
            updatable = false
    )

    private LocalDate dob;

    public User() {
    }

    public User(UUID id, String firstName, String lastName, String email, String password, String phoneNumber, UserType userType, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.dob = dob;
    }

    public User(String firstName, String lastName, String email, String password, String phoneNumber, UserType userType, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.dob = dob;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userType=" + userType +
                ", dob=" + dob +
                '}';
    }
}

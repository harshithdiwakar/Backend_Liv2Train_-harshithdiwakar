package com.example.interviewdemo.model;

import com.example.interviewdemo.model.validators.PatternValidator;
import com.example.interviewdemo.model.validators.SizeValidator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "training_center")
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column(length = 40)
    @NotNull
    private String centerName;

    @Column(length = 12)
    @NotNull
    @PatternValidator(message = "please provide alphanumeric value for center code", pattern = "^[a-zA-Z0-9]*$")
    @SizeValidator(message = "size of code should be exactly 12", size = 12)
    private String centerCode;

    @OneToOne(cascade = {CascadeType.ALL})
    @NotNull
    private Address address;

    @Column
    private int studentCapacity;

    @ElementCollection(targetClass = String.class)
    private List<String> coursesOffered;

    @Column
    private long createdOn = System.currentTimeMillis();

    @Column
    @PatternValidator(message = "please provide a valid email", pattern = "^[a-zA-Z0-9_!#$%^&*~+-?]+@[a-zA-Z0-9.-]+$")
    private String contactEmail;

    @Column
    @PatternValidator(message = "please provide a valid phone number", pattern = "^[0-9]{10}$")
    private String contactPhone;

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public List<String> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<String> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package org.example.entities;

import jakarta.persistence.*;

@Entity
public class StudentDetail {

    @Id
    @GeneratedValue
    @Column(name = "STUDENTDETAIL_ID")
    int studentDetailId;

    @Column(name = "ZIPCODE")
    int zipCode;

    public int getStudentDetailId() {
        return studentDetailId;
    }

    public void setStudentDetailId(int studentDetailId) {
        this.studentDetailId = studentDetailId;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}

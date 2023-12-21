package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id @GeneratedValue @Column(name = "STUDENT_ID")
    private int studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="STDETAIL_FK")
    private StudentDetail studentDetail;

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
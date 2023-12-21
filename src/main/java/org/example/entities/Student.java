package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student {

    @Id @GeneratedValue @Column(name = "STUDENT_ID")
    private int studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COLLEGE_FK")
    private StudentCollege studentCollege;

    public StudentCollege getStudentCollege() {
        return studentCollege;
    }

    public void setStudentCollege(StudentCollege studentCollege) {
        this.studentCollege = studentCollege;
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


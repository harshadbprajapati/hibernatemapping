package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENT_COLLEGE")
public class StudentCollege {
    @Id
    @GeneratedValue
    @Column(name = "COLLEGE_ID")
    private Long collegeId;

    @Column(name = "COLLEGE_NAME")
    private String collegeName;
    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Long getCollegeId() {
        return collegeId;
    }
}

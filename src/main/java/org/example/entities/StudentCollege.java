package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "STUDENT_COLLEGE")
public class StudentCollege {
    @Id
    @GeneratedValue
    @Column(name = "COLLEGE_ID")
    private Long collegeId;

    @Column(name = "COLLEGE_NAME")
    private String collegeName;

    @OneToMany(mappedBy = "studentCollege",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

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

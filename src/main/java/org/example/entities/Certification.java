package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Certification {
    @Id
    @GeneratedValue
    @Column(name = "CERTIFICATION_ID")
    private Long certificationId;

    @Column(name = "CERTIFICATION_NAME")
    private String certificationName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_STUDENT_CERTIFICATION",
            joinColumns =  {@JoinColumn(name = "CERTIFICATION_ID_FK") },
            inverseJoinColumns = {@JoinColumn(name = "STUDENT_ID_FK")}
    )
    private Set<Student> students;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Long getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Long certificationId) {
        this.certificationId = certificationId;
    }

    public String getCertificationName() {
        return certificationName;
    }

    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }
}

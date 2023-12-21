package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student {

    @Id @GeneratedValue @Column(name = "STUDENT_ID")
    private int studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_STUDENT_CERTIFICATION",
        joinColumns =  {@JoinColumn(name = "STUDENT_ID_FK") },
        inverseJoinColumns = {@JoinColumn(name = "CERTIFICATION_ID_FK")}
    )
    private Set<Certification> studentCertificates;

    public Set<Certification> getStudentCertificates() {
        return studentCertificates;
    }

    public void setStudentCertificates(Set<Certification> studentCertificates) {
        this.studentCertificates = studentCertificates;
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

// Student class used in ManyToOne and OneToMany relationships
//@Entity
//public class Student {
//
//    @Id @GeneratedValue @Column(name = "STUDENT_ID")
//    private int studentId;
//
//    @Column(name = "STUDENT_NAME")
//    private String studentName;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "COLLEGE_FK")
//    private StudentCollege studentCollege;
//
//    public StudentCollege getStudentCollege() {
//        return studentCollege;
//    }
//
//    public void setStudentCollege(StudentCollege studentCollege) {
//        this.studentCollege = studentCollege;
//    }
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//}


// Student class used in OneToOne relationship
//package org.example.entities;
//
//        import jakarta.persistence.*;
//
//@Entity
//public class Student {
//
//    @Id @GeneratedValue @Column(name = "STUDENT_ID")
//    private int studentId;
//
//    @Column(name = "STUDENT_NAME")
//    private String studentName;
//
//    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinColumn(name="STDETAIL_FK")
//    private StudentDetail studentDetail;
//
//    public StudentDetail getStudentDetail() {
//        return studentDetail;
//    }
//
//    public void setStudentDetail(StudentDetail studentDetail) {
//        this.studentDetail = studentDetail;
//    }
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//}

package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Certification {
    @Id
    @GeneratedValue
    @Column(name = "CERTIFICATION_ID")
    private Long certificationId;

    @Column(name = "CERTIFICATION_NAME")
    private String certificationName;

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

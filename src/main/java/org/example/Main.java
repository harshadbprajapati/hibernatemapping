package org.example;

import org.example.entities.Certification;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.entities.Student.class);
        config.addAnnotatedClass(org.example.entities.Certification.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            // Create three students
            Student tom = new Student();
            tom.setStudentName("Tom Cruise");

            Student will = new Student();
            will.setStudentName("Will Smith");

            Student keanu = new Student();
            keanu.setStudentName("Keanu Reeves");

            // Create three certificates
            Certification awsCloud = new Certification();
            awsCloud.setCertificationName("AWS Certified Cloud Practitioner");

            Certification oracleJava = new Certification();
            oracleJava.setCertificationName("Oracle Certified Associate Java Programmer");

            Certification vmwareSpring = new Certification();
            vmwareSpring.setCertificationName("Spring Certified Professional");

            // Create set of certificates for each student
            Set<Certification> tomCertificates = new HashSet<Certification>();
            tomCertificates.add(oracleJava);
            tomCertificates.add(vmwareSpring);

            Set<Certification> willCertificates = new HashSet<Certification>();
            willCertificates.add(awsCloud);

            Set<Certification> keanuCertificates = new HashSet<Certification>();
            keanuCertificates.add(awsCloud);
            keanuCertificates.add(oracleJava);
            keanuCertificates.add(vmwareSpring);

            // Assign set of certificates to each student
            tom.setStudentCertificates(tomCertificates);
            will.setStudentCertificates(willCertificates);
            keanu.setStudentCertificates(keanuCertificates);

            // Store the students
            session.persist(tom);
            session.persist(will);
            session.persist(keanu);

            session.getTransaction().commit();

        } finally{
            session.close();
            sessionFactory.close();
        }
    }
}

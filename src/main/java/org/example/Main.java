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

// OneToMany with ManyToOne bidirectional mapping
//package org.example;
//
//        import org.example.entities.Student;
//        import org.example.entities.StudentCollege;
//        import org.hibernate.Session;
//        import org.hibernate.SessionFactory;
//        import org.hibernate.cfg.Configuration;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(org.example.entities.Student.class);
//        config.addAnnotatedClass(org.example.entities.StudentCollege.class);
//        SessionFactory sessionFactory = config.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        try {
//            session.beginTransaction();
//
//            // Create three students
//            Student tom = new Student();
//            tom.setStudentName("Tom Cruise");
//
//            Student will = new Student();
//            will.setStudentName("Will Smith");
//
//            Student keanu = new Student();
//            keanu.setStudentName("Keanu Reeves");
//
//            // Create two colleges
//            StudentCollege standford = new StudentCollege();
//            standford.setCollegeName("Standford University");
//
//            StudentCollege princeton = new StudentCollege();
//            princeton.setCollegeName("Princeton University");
//
//            // Set colleges for all students
//            tom.setStudentCollege(standford);
//            will.setStudentCollege(princeton);
//            keanu.setStudentCollege(standford);
//
//            // Create lists for students for colleges
//            List standfordStudents = new ArrayList();
//            standfordStudents.add(tom);
//            standfordStudents.add(keanu);
//
//            List princetonStudents = new ArrayList();
//            princetonStudents.add(will);
//
//            // Set lists of students for colleges
//            standford.setStudents(standfordStudents);
//            princeton.setStudents(princetonStudents);
//
//            // Store the colleges
//            session.persist(standford);
//            session.persist(princeton);
//
//            session.getTransaction().commit();
//
//        } finally{
//            session.close();
//            sessionFactory.close();
//        }
//    }
//}


// ManyToOne Example
//package org.example;
//
//        import org.example.entities.Student;
//        import org.example.entities.StudentCollege;
//        import org.hibernate.Session;
//        import org.hibernate.SessionFactory;
//        import org.hibernate.cfg.Configuration;
//
//public class Main {
//    public static void main(String[] args) {
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(org.example.entities.Student.class);
//        config.addAnnotatedClass(org.example.entities.StudentCollege.class);
//        SessionFactory sessionFactory = config.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        try {
//            session.beginTransaction();
//
//            // Create three students
//            Student tom = new Student();
//            tom.setStudentName("Tom Cruise");
//
//            Student will = new Student();
//            will.setStudentName("Will Smith");
//
//            Student keanu = new Student();
//            keanu.setStudentName("Keanu Reeves");
//
//            // Create two colleges
//            StudentCollege standford = new StudentCollege();
//            standford.setCollegeName("Standford University");
//
//            StudentCollege princeton = new StudentCollege();
//            princeton.setCollegeName("Princeton University");
//
//            // Set colleges for all students
//            tom.setStudentCollege(standford);
//            will.setStudentCollege(princeton);
//            keanu.setStudentCollege(standford);
//
//            // Store the students
//            session.persist(tom);
//            session.persist(will);
//            session.persist(keanu);
//
//            session.getTransaction().commit();
//
//        } finally{
//            session.close();
//            sessionFactory.close();
//        }
//
//    }
//}


//package org.example;
//
//        import org.example.entities.Student;
//        import org.example.entities.StudentDetail;
//        import org.hibernate.Session;
//        import org.hibernate.SessionFactory;
//        import org.hibernate.cfg.Configuration;
//
//public class Main {
//    public static void main(String[] args) {
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(org.example.entities.Student.class);
//        config.addAnnotatedClass(org.example.entities.StudentDetail.class);
//        SessionFactory sessionFactory = config.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        try {
//            session.beginTransaction();
//
//            StudentDetail tomDetail = new StudentDetail();
//            tomDetail.setZipCode(387001);
//
//            Student tom = new Student();
//            tom.setStudentName("Tom Cruise");
//            tom.setStudentDetail(tomDetail);
//
//            tomDetail.setStudent(tom);
//
////            session.persist(tom);
//            session.persist(tomDetail);
//
//            session.getTransaction().commit();
//
//        } finally{
//            session.close();
//            sessionFactory.close();
//        }
//
//    }
//}
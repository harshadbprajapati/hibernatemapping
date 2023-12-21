package org.example;

import org.example.entities.Student;
import org.example.entities.StudentDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.entities.Student.class);
        config.addAnnotatedClass(org.example.entities.StudentDetail.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            StudentDetail tomDetail = new StudentDetail();
            tomDetail.setZipCode(387001);

            Student tom = new Student();
            tom.setStudentName("Tom Cruise");
            tom.setStudentDetail(tomDetail);

            session.persist(tom);
//            session.persist(tomDetail);

            session.getTransaction().commit();

        } finally{
            session.close();
            sessionFactory.close();
        }

    }
}
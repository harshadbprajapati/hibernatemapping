package org.example;

import org.example.entities.Student;
import org.example.entities.StudentCollege;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.entities.Student.class);
        config.addAnnotatedClass(org.example.entities.StudentCollege.class);
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

            // Create two colleges
            StudentCollege standford = new StudentCollege();
            standford.setCollegeName("Standford University");

            StudentCollege princeton = new StudentCollege();
            princeton.setCollegeName("Princeton University");

            // Set colleges for all students
            tom.setStudentCollege(standford);
            will.setStudentCollege(princeton);
            keanu.setStudentCollege(standford);

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

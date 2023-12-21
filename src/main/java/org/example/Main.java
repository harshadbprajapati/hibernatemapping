package org.example;

import org.example.entities.Student;
import org.example.entities.StudentCollege;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

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

            // Create lists for students for colleges
            List standfordStudents = new ArrayList();
            standfordStudents.add(tom);
            standfordStudents.add(keanu);

            List princetonStudents = new ArrayList();
            princetonStudents.add(will);

            // Set lists of students for colleges
            standford.setStudents(standfordStudents);
            princeton.setStudents(princetonStudents);

            // Store the colleges
            session.persist(standford);
            session.persist(princeton);

            session.getTransaction().commit();

        } finally{
            session.close();
            sessionFactory.close();
        }
    }
}

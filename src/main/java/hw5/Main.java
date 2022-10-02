package hw5;

import hw5.dao.StudentDao;
import hw5.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml")
                .buildSessionFactory();

        StudentDao studentDao = new StudentDao(sessionFactory);


        for (int i = 1; i <= 1000; i++) {
            studentDao.create("Name " + i, (int)(Math.random() * 5));
        }

        studentDao.update(15L, "OLeg", 3);

        List<Student> studentList = studentDao.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }

        Student student = studentDao.findById(45L);
        System.out.println(student);

        studentDao.detete(5L);


        sessionFactory.close();
    }
}

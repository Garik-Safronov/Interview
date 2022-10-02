package hw5.dao;

import hw5.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDao {

    private final SessionFactory sessionFactory;
    private Session session;

    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(String name, int mark) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = new Student(name, mark);
        session.save(student);
        session.getTransaction().commit();
    }

    public void update(Long id, String name, int mark){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        student.setName(name);
        student.setMark(mark);
        session.getTransaction().commit();
    }

    public Student findById(Long id){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        return student;
    }

    public List<Student> findAll(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Student> studentList = session.createQuery("from Student ").list();
        session.getTransaction().commit();
        return studentList;
    }

    public void detete(Long id){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
    }
}

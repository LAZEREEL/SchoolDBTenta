package management;

import Entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentManager {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public static void main(String[] args) {
        createStudent("Dennis","man",24);
    }

    public static void createStudent(String name, String gender, int age){
        Student student = new Student(name,gender,age);

        addStudent(student);
    }

    public static void addStudent(Student student){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(student);

        em.getTransaction().commit();

        em.close();
    }
}

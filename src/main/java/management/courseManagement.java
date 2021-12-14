package management;

import Entity.Course;
import Entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class courseManagement {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public static void printCourse(int id){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Course course = em.find(Course.class, id);

        System.out.println(course);
        System.out.println("Teacher: " + " " + course.getTeacher());
        course.getStudents().size();
        System.out.println("Students: " + course.getStudents());

        em.getTransaction().commit();
        em.close();

    }

}

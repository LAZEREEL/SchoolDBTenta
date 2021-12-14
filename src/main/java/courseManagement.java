import Entity.Course;
import Entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class courseManagement {

    public static void printCourse(int id){

        EntityManager em = Main.emf.createEntityManager();

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

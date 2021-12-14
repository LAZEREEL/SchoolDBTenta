import Entity.Course;
import Entity.Department;
import Entity.Student;
import Entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        UI.menuLoop();



/*
        Student a = new Student("banana joe", "Male", 22);
        Course b = new Course("Math 1");
        Teacher c = new Teacher("Banana Sue", 46, "Female", 4206969);
        Department d = new Department("Science");
*/




    }
}









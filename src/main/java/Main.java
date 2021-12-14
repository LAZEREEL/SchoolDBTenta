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





    }
}









package management;

import Entity.Course;
import Entity.Student;
import Entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CourseManagement {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public static void printCourse(int id){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Course course = em.find(Course.class, id);

        System.out.println(course);
        System.out.println("Teacher: " + " " + course.getTeacher());
        course.getStudents().size(); //To counter a bug that prevents list of Students from being initialized
        System.out.println("Students: " + course.getStudents());

        em.getTransaction().commit();
        em.close();


    }

    public static void printAllCourses(){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        TypedQuery<Course> q = em.createQuery("SELECT b FROM Course b", Course.class);
        q.getResultStream().forEach(System.out::println);

        em.close();

    }

    public static void addCourse(String name){
        EntityManager em = emf.createEntityManager();

        Course newCourse = new Course(name);

        em.getTransaction().begin();
        em.persist(newCourse);
        em.getTransaction().commit();
        em.close();

    }

    public static void updateCourse(String newName, int id){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Course updateCourse = em.find(Course.class, id);

        updateCourse.setName(newName);

        em.refresh(updateCourse);
        em.getTransaction().commit();
        em.close();
    }

    public static void removeCourse(int id){
        EntityManager em = emf.createEntityManager();

        Course courseToRemove = em.find(Course.class, id);

        em.getTransaction().begin();
        em.remove(courseToRemove);
        em.getTransaction().commit();
        em.close();

    }

    public static void addStudentToCourse(int idOfStudentToAdd, int idOfCourseToAddStudentTo){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student addStudentToCourse = em.find(Student.class, idOfStudentToAdd);
        Course courseToAddStudentTo = em.find(Course.class, idOfCourseToAddStudentTo);

        courseToAddStudentTo.addStudent(addStudentToCourse);

        em.getTransaction().commit();
        em.close();
    }

    public static void removeStudentFromCourse(int idOfStudentToRemove, int idOfCourseToRemoveStudentFrom){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student removeStudentFromCourse = em.find(Student.class, idOfStudentToRemove);
        Course courseToRemoveStudentFrom = em.find(Course.class, idOfCourseToRemoveStudentFrom);

        courseToRemoveStudentFrom.removeStudent(removeStudentFromCourse);

        em.getTransaction().commit();
        em.close();
    }
}

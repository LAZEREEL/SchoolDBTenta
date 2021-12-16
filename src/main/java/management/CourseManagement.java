package management;

import Entity.Course;
import Entity.Student;
import Entity.Teacher;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseManagement {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public static void printCourse(int id) {

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

    public static void printAllCourses() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        TypedQuery<Course> q = em.createQuery("SELECT b FROM Course b", Course.class);
        q.getResultStream().forEach(System.out::println);

        em.close();

    }

    public static void addCourse(String name) {
        EntityManager em = emf.createEntityManager();

        Course newCourse = new Course(name);

        em.getTransaction().begin();

        em.persist(newCourse);
        em.getTransaction().commit();
        em.close();

    }

    public static void updateCourse(String newName, int id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Course updateCourse = em.find(Course.class, id);

        updateCourse.setName(newName);

        em.getTransaction().commit();
        em.close();
    }

    public static void removeCourse(int id) {
        EntityManager em = emf.createEntityManager();

        Course courseToRemove = em.find(Course.class, id);

        em.getTransaction().begin();

        courseToRemove.setTeacher(null);
        courseToRemove.setStudents(null);

        em.remove(courseToRemove);
        em.getTransaction().commit();
        em.close();

    }

    public static void addStudentToCourse(int idOfStudentToAdd, int idOfCourseToAddStudentTo) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student addStudentToCourse = em.find(Student.class, idOfStudentToAdd);
        Course courseToAddStudentTo = em.find(Course.class, idOfCourseToAddStudentTo);

        courseToAddStudentTo.addStudent(addStudentToCourse);

        em.getTransaction().commit();
        em.close();
    }

    public static void removeStudentFromCourse(int idOfStudentToRemove, int idOfCourseToRemoveStudentFrom) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student removeStudentFromCourse = em.find(Student.class, idOfStudentToRemove);
        Course courseToRemoveStudentFrom = em.find(Course.class, idOfCourseToRemoveStudentFrom);

        courseToRemoveStudentFrom.removeStudent(removeStudentFromCourse);

        em.getTransaction().commit();
        em.close();
    }

    public static void addTeacherToCourse(int idOfTeacherToAdd, int idOfCourseToAddTeacherTo) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Teacher addTeacherToCourse = em.find(Teacher.class, idOfTeacherToAdd);
        Course courseToAddTeacherTo = em.find(Course.class, idOfCourseToAddTeacherTo);

        courseToAddTeacherTo.setTeacher(addTeacherToCourse);

        em.getTransaction().commit();
        em.close();
    }

    public static void removeTeacherFromCourse(int idOfCourseToRemoveTeacherFrom) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        Course courseToRemoveTeacherFrom = em.find(Course.class, idOfCourseToRemoveTeacherFrom);

        courseToRemoveTeacherFrom.setTeacher(null);

        em.getTransaction().commit();
        em.close();
    }

    public static void displayAllCourses() {
        //kurser (Printa ut alla kurser med id och namn, ansvarig lärare med id och namn och antal studenter)
        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> queryA = em.createQuery("SELECT b FROM Course b", Course.class);

        Stream<Course> courses = queryA.getResultStream();

        System.out.println("======================================== Courses ========================================");
        courses.forEach(b -> System.out.println(" Id: " + b.getId() + " " + "Name: " + b.getName() + " "
                + "Number of Students: " + b.getStudents().size() + " " + "Teacher: " + " " + "id: " +
                b.getTeacher().getId() + " " + "Name: " + b.getTeacher().getName() + " "));

        em.close();
    }

    public static void displaySpecificCourse(int id) {
        //Teacher needs to be assigned to course for method to work
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Course course = em.find(Course.class, id);
        int numberOfStudents = course.getStudents().size();

        Double averageAge = course.getStudents()
                .stream()
                .collect(Collectors.averagingInt(p -> p.getAge()));

        List<Course> female = em.createQuery("SELECT s FROM Student s WHERE s.gender=:gender").setParameter("gender","female").getResultList();

        double numberOfFemale = female.size();
        double avgFemaleInCourse = numberOfFemale / numberOfStudents;


        List<Course> male = em.createQuery("SELECT s FROM Student s WHERE s.gender=:gender").setParameter("gender","male").getResultList();

        double numberOfMale = male.size();
        double avgMaleInCourse = numberOfMale / numberOfStudents;


        System.out.println("===================================== " + "Id: " + course.getId() + " " + "Course: " + course.getName() + " =====================================");
        System.out.println("Number of Students: " + numberOfStudents);
        System.out.println("Average age of Students: " + averageAge);
        System.out.println("Gender distribution");
        System.out.println("Female students: " + numberOfFemale + " Average: " + avgFemaleInCourse);
        System.out.println("Male students: " + numberOfMale + " Average: " + avgMaleInCourse);


    }
}


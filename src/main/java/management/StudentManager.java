package management;

import Entity.Course;
import Entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    static Scanner sc = new Scanner(System.in);

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

    public static void printStudentById(int id) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);

        System.out.println("Here you have the following information about the student:");
        System.out.println(student);

        em.close();
    }

    public static void printAllStudents() {
        EntityManager em = emf.createEntityManager();

        List<Student> students = em.createQuery("SELECT s FROM Student s").getResultList();

        System.out.println("Here you have information about all the students:");
        students.forEach(System.out::println);

        em.close();
    }

    public static void updateStudentMenu(int id) {
        boolean loop = true;

        while (loop){
            System.out.println("=====================");
            System.out.println("Update Student Menu");
            System.out.println("=====================");
            System.out.println("1.Update student's name");
            System.out.println("2.Update student's gender");
            System.out.println("3.Update student's age");
            System.out.println("4.Update all of the above");
            System.out.println("0.Back to student menu");

            System.out.print("choice:");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.print("new name:");
                    String newName = sc.nextLine();

                    updateStudentsName(id,newName);
                    break;

                case 2:
                    System.out.print("new gender:");
                    String newGender = sc.nextLine();

                    updateStudentsGender(id,newGender);
                    break;

                case 3:
                    System.out.print("new age:");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    updateStudentsAge(id,newAge);
                    break;

                case 4:
                    System.out.print("new name:");
                    newName = sc.nextLine();

                    System.out.print("new gender:");
                    newGender = sc.nextLine();


                    System.out.print("new age:");
                    newAge = sc.nextInt();
                    sc.nextLine();

                    updateAllStudentInfo(id,newName,newGender,newAge);
                    break;

                case 0:
                    loop = false;
                    break;

                default:
                    System.out.println("There's no such option, try again");
                    break;
            }
        }
    }

    private static void updateAllStudentInfo(int id, String newName, String newGender, int newAge) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);

        em.getTransaction().begin();

        student.setName(newName);

        student.setGender(newGender);

        student.setAge(newAge);

        em.getTransaction().commit();

        em.close();
    }

    private static void updateStudentsAge(int id, int newAge) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);

        em.getTransaction().begin();

        student.setAge(newAge);

        em.getTransaction().commit();

        em.close();
    }

    private static void updateStudentsGender(int id, String newGender) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);

        em.getTransaction().begin();

        student.setGender(newGender);

        em.getTransaction().commit();

        em.close();
    }

    private static void updateStudentsName(int id, String newName) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);

        em.getTransaction().begin();

        student.setName(newName);

        em.getTransaction().commit();

        em.close();
    }

    public static void removeStudent(int id) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);

        em.getTransaction().begin();

        student.setCourses(null);

        em.remove(student);

        em.getTransaction().commit();

        em.close();
    }

    public static void studentStatistics() {
        EntityManager em = emf.createEntityManager();

        List<Student> students = em.createNativeQuery("SELECT * FROM Student").getResultList();

        System.out.println("The total number of students is " + students.size());


        double avgAge = (double) em.createNativeQuery("SELECT AVG(age) FROM Student").getSingleResult();

        System.out.println("The avg for all students is " + avgAge);

        em.close();
    }
}

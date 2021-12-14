package management;

import Entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    static boolean loop = true;
    static Scanner sc = new Scanner(System.in);

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
        while (loop){
            System.out.println("=====================");
            System.out.println("Update Student Menu");
            System.out.println("=====================");
            System.out.println("1.Update student's name");
            System.out.println("2.Update student's gender");
            System.out.println("3.Update student's gender");
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
            }
        }
    }

    private static void updateStudentsName(int id, String newName) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);

        em.getTransaction().begin();

        student.setName(newName);

        em.getTransaction().commit();

        em.close();
    }
}

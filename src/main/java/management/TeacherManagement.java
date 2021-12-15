package management;

import Entity.Course;
import Entity.Department;
import Entity.Teacher;



import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class TeacherManagement {
    static Scanner sc = new Scanner(System.in);
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    static DepartmentManager dm = new DepartmentManager();

    public static void disconnectTeacherFromDepartment() {

        EntityManager em = emf.createEntityManager();
        printAllTeachersAndTheirDepartment();
        System.out.println("Teacher id:");
        int teacherId = sc.nextInt();
        sc.nextLine();

        Teacher teacher = em.find(Teacher.class, teacherId);

        em.getTransaction().begin();

        teacher.setDepartment(null);

        em.getTransaction().commit();

        em.close();

    }

    public static void connectTeacherToDepartment() {

        EntityManager em = emf.createEntityManager();

        printAllTeachersAndTheirDepartment();
        System.out.println("Teacher id:");
        int teacherId = sc.nextInt();
        sc.nextLine();

        dm.printAllDepartment();
        System.out.println("Department id:");
        int departmentId = sc.nextInt();
        sc.nextLine();

        Teacher teacher = em.find(Teacher.class, teacherId);

        Department department = em.find(Department.class, departmentId);

        em.getTransaction().begin();

        teacher.setDepartment(department);

        em.getTransaction().commit();

        em.close();

    }

    public static void removeTeacherById(int id) {

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        Teacher theTeacher = em.find(Teacher.class, id);

        em.getTransaction().begin();

        em.remove(theTeacher);

        theTeacher.getCourse().setTeacher(null);

        em.getTransaction().commit();

        em.close();


    }

    public static void disconnectTeacherFromCourse(int id) {

        EntityManager em = emf.createEntityManager();

        Teacher teacher = em.find(Teacher.class, id);

        em.getTransaction().begin();


        teacher.getCourse().setTeacher(null);
        teacher.setCourse(null);


        em.getTransaction().commit();

        em.close();

    }

    public static void printAllTeachersAndTheirDepartment(){

        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);

        List<Teacher> teachers = query.getResultList();

        teachers.forEach(t -> System.out.println(" Id=" + t.getId() + ", name=" + t.getName() + ", age="
                + t.getAge() + " " + t.getDepartment()));

        em.close();

    }

    public static void printAllTeachersAndTheirCourse() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);

        List<Teacher> teachers = query.getResultList();

        teachers.forEach(t -> System.out.println(" Id=" + t.getId() + ", name=" + t.getName() + ", age="
                + t.getAge() + " " + t.getCourse()));

        em.close();
    }

    public static void printTeachersAndDepartmentAndTheirCourse() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);

        List<Teacher> teachers = query.getResultList();

        teachers.forEach(t -> System.out.println(" Id=" + t.getId() + ", name=" + t.getName() + ", age="
                + t.getAge() + " " + t.getDepartment() + ", " + t.getCourse()));

        em.close();


    }





    public static void updateSalary() {

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        System.out.println("Teacher id:");
        int tId = sc.nextInt();
        sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        System.out.println("New salary:");
        double salary = sc.nextDouble();

        em.getTransaction().begin();

        theTeacher.setSalary(salary);

        em.getTransaction().commit();

        em.close();


    }

    public static void updateGender() {

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        System.out.println("Teacher id:");
        int tId = sc.nextInt();
        sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        System.out.println("New gender:");
        String gender = sc.nextLine();

        em.getTransaction().begin();

        theTeacher.setGender(gender);

        em.getTransaction().commit();

        em.close();


    }

    public static void updateAge() {

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        System.out.println("Teacher id:");
        int tId = sc.nextInt();
        sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        System.out.println("New age:");
        int age = sc.nextInt();

        em.getTransaction().begin();

        theTeacher.setAge(age);

        em.getTransaction().commit();

        em.close();


    }

    public static void updateName() {

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        System.out.println("Teacher id:");
        int tId = sc.nextInt();
        sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        System.out.println("New name:");
        String name = sc.nextLine();

        em.getTransaction().begin();

        theTeacher.setName(name);

        em.getTransaction().commit();

        em.close();

    }

    public static void updateAllFields(int id) {

        EntityManager em = emf.createEntityManager();

        Teacher theTeacher = em.find(Teacher.class, id);

        System.out.println("New name:");
        String name = sc.nextLine();

        System.out.println("New age:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("New gender:");
        String gender = sc.nextLine();

        System.out.println("New salary:");
        double salary = sc.nextDouble();


        em.getTransaction().begin();

        theTeacher.setName(name);
        theTeacher.setAge(age);
        theTeacher.setGender(gender);
        theTeacher.setSalary(salary);

        em.getTransaction().commit();

        em.close();

    }


    public static void connectTeacherToCourse() {

        EntityManager em = emf.createEntityManager();

        printAllTeachersAndTheirCourse();

        System.out.println("Teacher id:");
        int tId = sc.nextInt();
        sc.nextLine();

        CourseManagement.printAllCourses();
        System.out.println("Course id:");
        int cId = sc.nextInt();
        sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        Course theCourse = em.find(Course.class, cId);

        em.getTransaction().begin();

        theCourse.setTeacher(theTeacher);
        theTeacher.setCourse(theCourse);

        em.getTransaction().commit();

        em.close();

    }

    public static void printTeacherAndDepartment() {

        EntityManager em = emf.createEntityManager();

        System.out.println("Teacher id:");
        int id = sc.nextInt();
        sc.nextLine();

        Query query = em.createQuery("SELECT t FROM Teacher t WHERE t.id =:id");

        query.setParameter("id", id);

        Teacher t = (Teacher) query.getSingleResult();

        System.out.println("Id=" + t.getId() + ", name=" + t.getName() + ", age=" + t.getAge()
                + ", gender=" + t.getGender() + ", salary=" + t.getSalary()
                + ", " + t.getDepartment());


        em.close();


    }

    public static void printTeacherAndCourse() {

        EntityManager em = emf.createEntityManager();

        System.out.println("Teacher id:");
        int id = sc.nextInt();
        sc.nextLine();

        Query query = em.createQuery("SELECT t FROM Teacher t WHERE t.id =:id");

        query.setParameter("id", id);

        Teacher t = (Teacher) query.getSingleResult();

        System.out.println("Id=" + t.getId() + ", name=" + t.getName() + ", age=" + t.getAge()
                + ", gender=" + t.getGender() + ", salary=" + t.getSalary()
                + ", " + t.getCourse());


        em.close();


    }


    public static void printTeacherById(int id) {

        EntityManager em = emf.createEntityManager();

        Teacher theTheacher = em.find(Teacher.class, id);

        System.out.println(theTheacher);

        em.close();
    }

    public static void printAllTeachers() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);

        List<Teacher> teachers = query.getResultList();

        teachers.forEach(System.out::println);

        em.close();
    }

    public static void addTeacher(Teacher t) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();

        em.close();

    }

    public static void printTeacherMenu() {

        System.out.println("1.Print Teacher by id");
        System.out.println("2.Print Teacher and course");
        System.out.println("3.Print Teacher and department");
        System.out.println("4.Print all information about Teachers ");


        int printChoice = sc.nextInt();
        sc.nextLine();

        switch (printChoice) {

            case 1:

                System.out.println("Teacher id:");
                int id = sc.nextInt();
                sc.nextLine();
                TeacherManagement.printTeacherById(id);

                break;

            case 2:
                TeacherManagement.printTeacherAndCourse();
                break;

            case 3:
                TeacherManagement.printTeacherAndDepartment();
                break;

            case 4:
                TeacherManagement.printTeachersAndDepartmentAndTheirCourse();
                break;



        }

    }

    public static void updateTeacherMenu() {

        System.out.println("1. Update all fields");
        System.out.println("2. Update name");
        System.out.println("3. Update age");
        System.out.println("4. Update gender");
        System.out.println("5. Update salary");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                TeacherManagement.printAllTeachers();

                System.out.println("Teacher id:");
                int tId = sc.nextInt();
                sc.nextLine();
                TeacherManagement.updateAllFields(tId);
                break;

            case 2:
                TeacherManagement.updateName();
                break;
            case 3:
                TeacherManagement.updateAge();
                break;
            case 4:
                TeacherManagement.updateGender();
                break;
            case 5:
                TeacherManagement.updateSalary();
                break;

        }
    }
}

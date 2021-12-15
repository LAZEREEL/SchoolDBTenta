import Entity.Course;
import Entity.Department;
import Entity.Teacher;

import javax.persistence.*;
import java.util.List;

public class TeacherManagement {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    public static void removeTeacher(){

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        System.out.println("Teacher id:");
        int tId = UI.sc.nextInt();
        UI.sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        em.getTransaction().begin();

        em.remove(theTeacher);

        em.getTransaction().commit();

        em.close();


    }

    public static void updateSalary(){

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        System.out.println("Teacher id:");
        int tId = UI.sc.nextInt();
        UI.sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        System.out.println("New salary:");
        double salary = UI.sc.nextDouble();

        em.getTransaction().begin();

        theTeacher.setSalary(salary);

        em.getTransaction().commit();

        em.close();


    }

    public static void updateGender(){

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        System.out.println("Teacher id:");
        int tId = UI.sc.nextInt();
        UI.sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        System.out.println("New gender:");
        String gender = UI.sc.nextLine();

        em.getTransaction().begin();

        theTeacher.setGender(gender);

        em.getTransaction().commit();

        em.close();


    }

    public static void updateAge(){

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        System.out.println("Teacher id:");
        int tId = UI.sc.nextInt();
        UI.sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        System.out.println("New age:");
        int age = UI.sc.nextInt();

        em.getTransaction().begin();

        theTeacher.setAge(age);

        em.getTransaction().commit();

        em.close();


    }

    public static void updateName(){

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        System.out.println("Teacher id:");
        int tId = UI.sc.nextInt();
        UI.sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        System.out.println("New name:");
        String name = UI.sc.nextLine();

        em.getTransaction().begin();

        theTeacher.setName(name);

        em.getTransaction().commit();

        em.close();

    }

    public static void updateAllFields(){

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        System.out.println("Teacher id:");
        int tId = UI.sc.nextInt();
        UI.sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        System.out.println("New name:");
        String name = UI.sc.nextLine();

        System.out.println("New age:");
        int age = UI.sc.nextInt();
        UI.sc.nextLine();

        System.out.println("New gender:");
        String gender = UI.sc.nextLine();

        System.out.println("New salary:");
        double salary = UI.sc.nextDouble();


        em.getTransaction().begin();

        theTeacher.setName(name);
        theTeacher.setAge(age);
        theTeacher.setGender(gender);
        theTeacher.setSalary(salary);

        em.getTransaction().commit();

        em.close();

    }



    public static void connectTeacherToCourse(){

        EntityManager em = emf.createEntityManager();

        printAllTeachers();

        System.out.println("Teacher id:");
        int tId = UI.sc.nextInt();
        UI.sc.nextLine();

        System.out.println("Course id:");
        int cId = UI.sc.nextInt();
        UI.sc.nextLine();

        Teacher theTeacher = em.find(Teacher.class, tId);

        Course theCourse = em.find(Course.class, cId);

        em.getTransaction().begin();

        theTeacher.setCourse(theCourse);

        em.getTransaction().commit();

        em.close();

    }

    public static void printTeacherAndDepartment(){

        EntityManager em = emf.createEntityManager();

        System.out.println("Teacher id:");
        int id = UI.sc.nextInt();
        UI.sc.nextLine();

        Query query = em.createQuery("SELECT t FROM Teacher t WHERE t.id =:id");

        query.setParameter("id", id);

        Teacher t = (Teacher) query.getSingleResult();

        System.out.println("Id=" + t.getId() + ", name=" + t.getName() + ", age=" + t.getAge()
                + ", gender=" + t.getGender() + ", salary=" + t.getSalary()
                + ", " + t.getDepartment());


        em.close();


    }

    public static void printTeacherAndCourse(){

        EntityManager em = emf.createEntityManager();

        System.out.println("Teacher id:");
        int id = UI.sc.nextInt();
        UI.sc.nextLine();

        Query query = em.createQuery("SELECT t FROM Teacher t WHERE t.id =:id");

        query.setParameter("id", id);

        Teacher t = (Teacher) query.getSingleResult();

            System.out.println("Id=" + t.getId() + ", name=" + t.getName() + ", age=" + t.getAge()
                    + ", gender=" + t.getGender() + ", salary=" + t.getSalary()
                    + ", " + t.getCourse());


        em.close();


    }


    public static void printTeacherById(){

        EntityManager em = emf.createEntityManager();

        System.out.println("Teacher id:");
        int id = UI.sc.nextInt();
        UI.sc.nextLine();

        Teacher theTheacher = em.find(Teacher.class, id);

        System.out.println(theTheacher);

        em.close();
    }

    public static void printAllTeachers(){

        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);

        List<Teacher> teachers = query.getResultList();

        teachers.forEach(System.out::println);

        em.close();
    }

    public static void addTeacher(){

        EntityManager em = emf.createEntityManager();

        System.out.println("Name:");
        String name = UI.sc.nextLine();

        System.out.println("Age:");
        int age = UI.sc.nextInt();
        UI.sc.nextLine();

        System.out.println("Gender:");
        String gender = UI.sc.nextLine();

        System.out.println("Salary:");
        double salary = UI.sc.nextDouble();
        UI.sc.nextLine();

        Teacher teacher = new Teacher(name, age, gender, salary);

        em.getTransaction().begin();

        em.persist(teacher);

        em.getTransaction().commit();

        em.close();

    }

}

package management;

import Entity.Department;
import Entity.Teacher;

import javax.persistence.*;

import Entity.Course;

import java.util.*;



public class DepartmentManager {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");


    public void printAllDepartment() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        TypedQuery<Department> departmentTypedQuery = em.createQuery("SELECT department FROM Department department", Department.class);

        departmentTypedQuery.getResultStream().forEach(System.out::println);

        em.close();



    }


    public void createDepartment() { // 2
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        em.getTransaction().begin();
        System.out.println("Name: ");
        String name = sc.nextLine();
        Department department = new Department(name);
        em.persist(department);
        em.getTransaction().commit();
    }

    public void updateDepartment() { // 3
        Scanner sc = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();

        System.out.println("Enter Department ID: ");
        int depId = sc.nextInt();
        sc.nextLine();

        Department department = em.find(Department.class, depId);

        em.getTransaction().begin();
        System.out.println("Enter new department name! ");
        String newDepartmentName = sc.nextLine();
        department.setDepName(newDepartmentName);
        em.getTransaction().commit();
    }

    public void removeDepartment() { // 4
        EntityManager em = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Department Id");
        int depId = sc.nextInt();
        sc.nextLine();
        Department department = em.find(Department.class, depId);
        department.setId(depId);
        em.getTransaction().begin();
        em.remove(department);
        em.getTransaction().commit();
        System.out.println(department + " Have been removed!");
    }


    public void searchDepartmentById() { // 10
        Scanner sc = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        System.out.println("enter department id: ");
        int id = sc.nextInt();
        TypedQuery<Department> departmentTypedQuery = em.createQuery("SELECT department from " +
                "Department department where department.id=:id", Department.class);
        departmentTypedQuery.setParameter("id", id);
        try {
            Department department = departmentTypedQuery.getSingleResult();
            department.getId();
            System.out.println("DEPARTMENT FOUND!");
            System.out.println(department);
        } catch (NoResultException nre) {
            System.out.println("No department found: " + nre);
        }
    }


    public void addCourseToDepartment() {
        DepartmentManager departmentManager = new DepartmentManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Department ID");
        int depId = sc.nextInt();
        sc.nextLine();

        System.out.println("Course ID");
        int courseId = sc.nextInt();
        sc.nextLine();
        departmentManager.addCourseToDepartment(depId, courseId);
    }

    private void addCourseToDepartment(int depId, int courseId) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Course course = em.find(Course.class, courseId);
        Department department = em.find(Department.class, depId);

        department.addCourse(course);

        em.getTransaction().commit();
        em.close();

    }

    public void removeCourseFromDepartment() {
        DepartmentManager depmang = new DepartmentManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Department ID");
        int depId = sc.nextInt();
        sc.nextLine();

        System.out.println("Course ID");
        int courseId = sc.nextInt();
        sc.nextLine();
        depmang.removeCourse(depId, courseId);
    }


    private void removeCourse(int depId, int courseId) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Course course = em.find(Course.class, courseId);
        Department department = em.find(Department.class, depId);

        department.removeCourse(course);

        em.getTransaction().commit();
        em.close();
    }


    public void addTeacherToDepartment() {
        DepartmentManager depmang = new DepartmentManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Department ID");
        int depId = sc.nextInt();
        sc.nextLine();

        System.out.println("Teacher ID");
        int teacherId = sc.nextInt();
        sc.nextLine();
        depmang.addteacher(depId, teacherId);
    }

    private void addteacher(int depId, int teacherId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = em.find(Teacher.class, teacherId);
        Department department = em.find(Department.class, depId);
        department.addTeacher(teacher);
        em.getTransaction().commit();
        em.close();
    }

    public void removeTeacherToDepartment() {
        DepartmentManager depmang = new DepartmentManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Department ID");
        int depId = sc.nextInt();
        sc.nextLine();

        System.out.println("Teacher ID");
        int teacherId = sc.nextInt();
        sc.nextLine();
        depmang.removeteacher(depId, teacherId);
    }


    private void removeteacher(int depId, int teacherId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = em.find(Teacher.class, teacherId);
        Department department = em.find(Department.class, depId);
        department.removeTeacher(teacher);
        em.getTransaction().commit();
        em.close();
    }


    public void viewCoursesInASpecificDepartment() {
        Scanner sc = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        System.out.println("enter department id: ");
        int id = sc.nextInt();
        TypedQuery<Department> departmentTypedQuery = em.createQuery("SELECT department from " +
                "Department department where department.id=:id", Department.class);

        departmentTypedQuery.setParameter("id", id);



        try {
            Department courseInDepartment = departmentTypedQuery.getSingleResult();
            courseInDepartment.getCourseList();
            System.out.println(courseInDepartment.getCourseList().size() + " belongs to" + courseInDepartment);

        } catch (NoResultException nre) {
            System.out.println("No department found: " + nre);
        }
    }

}
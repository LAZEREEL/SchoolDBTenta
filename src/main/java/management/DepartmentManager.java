package Entity;
import Entity.Department;
import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class DepartmentManager {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");


    public void printAllDepartment() { // 1
        EntityManager em = emf.createEntityManager();
        TypedQuery<Department> departmentTypedQuery = em.createQuery("Select dep from Department  dep", Department.class);
        List<Department> departmentList = departmentTypedQuery.getResultList();
        departmentList.sort(Comparator.comparing(Department::getDepName));
        System.out.println(departmentList);
    }


    public void createDepartment() { // 2
        Scanner sc = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        System.out.println("Enter the name of the department: ");
        String depName = sc.nextLine();
        em.getTransaction().begin();
        Department department = new Department(depName);
        em.persist(department);
        em.getTransaction().commit();
        System.out.println(department + " have been added");
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


    public void connectCourse()  {
        Scanner sc = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();

        printAllDepartment();

        System.out.println("Department id:");
        int depId = sc.nextInt();
        sc.nextLine();

        System.out.println("Course id:");
        int courseId = sc.nextInt();
        sc.nextLine();

        Department department = em.find(Department.class, depId);

        Course course = em.find(Course.class, courseId);

        em.getTransaction().begin();

        department.setCourse(course);

        em.getTransaction().commit();

        em.close();
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

    public void findOutTeachers() { // 11
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
            System.out.println("Headmaster FOUND!");
            System.out.println(department.getTeacherList());
        } catch (NoResultException nre) {
            System.out.println("No department found: " + nre);
        }
    }


    public void readAllCoursesInThisDepartment() { // 12
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
            System.out.println("Headmaster FOUND!");
            System.out.println(department.getCourse());
        } catch (NoResultException nre) {
            System.out.println("No department found: " + nre);
        }
    }
}
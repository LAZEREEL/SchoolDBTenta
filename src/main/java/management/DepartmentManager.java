package management;
import Entity.Department;
import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class DepartmentManager {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    static int id;


    public void departmentMenu() {
        System.out.println("\n=================================");
        System.out.println("           Department Menu               ");
        System.out.println("=================================");
        System.out.println("1.Print all Departments");
        System.out.println("2.Add Department");
        System.out.println("3.Update Department");
        System.out.println("4.Remove Department");
        System.out.println("5.Connect Course to Department");
        System.out.println("6.Disconnect Course from Department");
        System.out.println("7.Connect Teacher to Department");
        System.out.println("8.Disconnect Teacher from Department");
        System.out.println("9. Search Department by Id");
        System.out.println("10. Search headmaster in department by depId");
        System.out.println("11. View all courses in a specific department by id");
        System.out.println("\n0.Exit");
        System.out.println("=================================");
        DepartmentManager depmang = new DepartmentManager();

    }


    public void removeDepartment() {
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

    }


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
        Department department = new Department(depName);
        em.getTransaction().begin();
        em.persist(department);
        em.getTransaction().commit();
        System.out.println(department + " have been added");
    }

    public void updateDepartment() { // 3
        Scanner sc = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();

        System.out.println("Enter Department ID: ");
        int depId = sc.nextInt();

        Department department = em.find(Department.class, id = depId);

        System.out.println("1. Update department name, 2. Update Headmaster");
        int updateChoice = sc.nextInt();
        sc.nextLine();

        if (updateChoice == 1) {
            System.out.println("Enter new department name! ");
            String newDepartmentName = sc.nextLine();
            em.getTransaction().begin();
            department.setDepName(newDepartmentName);
            em.getTransaction().commit();
        }
    }


    public void searchDepartmentById() { // 10
        Scanner sc = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        System.out.println("enter department id: ");
        id = sc.nextInt();
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
        id = sc.nextInt();
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
        id = sc.nextInt();
        TypedQuery<Department> departmentTypedQuery = em.createQuery("SELECT department from " +
                "Department department where department.id=:id", Department.class);
        departmentTypedQuery.setParameter("id", id);
        try {
            Department department = departmentTypedQuery.getSingleResult();
            department.getId();
            System.out.println("Headmaster FOUND!");
            System.out.println(department.getCourseList());
        } catch (NoResultException nre) {
            System.out.println("No department found: " + nre);
        }
    }
}
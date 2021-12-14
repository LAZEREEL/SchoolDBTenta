import Entity.StudentManager;

import java.util.Scanner;

public class UI {

    static Scanner sc = new Scanner(System.in);
    static boolean mainMenuLoop = true;
    static boolean studentMenuLoop = true;
    static boolean courseMenuLoop = true;
    static boolean teacherMenuLoop = true;
    static boolean departmentMenuLoop = true;
    static boolean statisticsMenuLoop = true;

    public static void menuLoop() {

        while (mainMenuLoop) {
            mainMenu();

            System.out.print("\nMake your choice:");
            int choice = sc.nextInt();
            sc.nextLine();

            menu(choice);

        }
    }

    public static void menu(int choice) {
        switch (choice) {

            case 1:
                while (studentMenuLoop) {
                    studentMenuUI();

                    System.out.print("\nMake your choice:");
                    int a = sc.nextInt();
                    sc.nextLine();

                    studentMenu(a);
                }
                break;

            case 2:
                while (courseMenuLoop) {
                    courseMenuUI();

                    System.out.print("\nMake your choice:");
                    int a = sc.nextInt();
                    sc.nextLine();

                    courseMenu(a);
                }
                break;
            case 3:
                while (teacherMenuLoop) {
                    teacherMenu();

                    System.out.print("\nMake your choice:");
                    int a = sc.nextInt();
                    sc.nextLine();

                    teacherMenu(a);
                }
                break;

            case 4:
                while (departmentMenuLoop) {
                    departmentMenu();

                    System.out.print("\nMake your choice:");
                    int a = sc.nextInt();
                    sc.nextLine();

                    departmentMenu(a);
                }
                break;

            case 5:

                break;


            case 0:
                mainMenuLoop = false;
                Main.emf.close();
                break;

            default:
                System.out.println("No such choice. Try again!");
        }
    }


    public static void mainMenu() {
        System.out.println("\n=================================");
        System.out.println("             Main Menu               ");
        System.out.println("=================================");
        System.out.println("1.Manage Students");
        System.out.println("2.Manage Course");
        System.out.println("3.Manage Teachers");
        System.out.println("4.Manage Deparment");
        System.out.println("5.School Statistics");

        System.out.println("\n0.Exit");
        System.out.println("=================================");

    }

    public static void studentMenuUI() {
        System.out.println("\n=================================");
        System.out.println("          Student Menu               ");
        System.out.println("=================================");
        System.out.println("1.Print Student");
        System.out.println("2.Print all Students");
        System.out.println("3.Add Student");
        System.out.println("4.Update Student");
        System.out.println("5.Remove Student");
        System.out.println("6.Connect Student to Course");
        System.out.println("7.Disconnect Student from Course");

        System.out.println("\n0.Back to Main Menu");
        System.out.println("=================================");

    }

    public static void studentMenu(int choice) {

        switch (choice) {

            case 1:
                System.out.print("name:");
                String name = sc.nextLine();

                System.out.print("gender:");
                String gender = sc.nextLine();

                System.out.print("age:");
                int age = sc.nextInt();
                sc.nextLine();

                StudentManager.createStudent(name,gender,age);
                break;

            case 0:
                studentMenuLoop = false;
                Main.emf.close();
                break;

            default:
                System.out.println("No such choice. Try again!");
        }
    }

    public static void courseMenuUI() {
        System.out.println("\n=================================");
        System.out.println("           Course Menu               ");
        System.out.println("=================================");
        System.out.println("1.Print Course");
        System.out.println("2.Print all Courses");
        System.out.println("3.Add Course");
        System.out.println("4.Update Course");
        System.out.println("5.Remove Course");
        System.out.println("6.Connect Student to Course");
        System.out.println("7.Disconnect Student from Course");
        System.out.println("8.Connect Teacher to Course");
        System.out.println("9.Disconnect Teacher from Course");

        System.out.println("\n0.Exit");
        System.out.println("=================================");

    }

    public static void courseMenu(int choice) {

        switch (choice) {

            case 1:
                System.out.println("Id of Course:");
                int id = sc.nextInt();
                sc.nextLine();
                courseManagement.printCourse(id);
                break;

            case 0:
                courseMenuLoop = false;
                Main.emf.close();
                break;

            default:
                System.out.println("No such choice. Try again!");
        }
    }

    public static void teacherMenu() {
        System.out.println("\n=================================");
        System.out.println("           Teacher Menu               ");
        System.out.println("=================================");
        System.out.println("1.Print Teacher");
        System.out.println("2.Print all Teachers");
        System.out.println("3.Add Teacher");
        System.out.println("4.Update Teacher");
        System.out.println("5.Remove Teacher");
        System.out.println("6.Connect Teacher to Course");
        System.out.println("7.Disconnect Teacher from Course");
        System.out.println("8.Connect Teacher to Department");
        System.out.println("9.Disconnect Teacher from Department");

        System.out.println("\n0.Exit");
        System.out.println("=================================");

    }

    public static void teacherMenu(int choice) {

        switch (choice) {

            case 1:

                break;

            case 0:
                teacherMenuLoop = false;
                Main.emf.close();
                break;

            default:
                System.out.println("No such choice. Try again!");
        }
    }

    public static void departmentMenu() {
        System.out.println("\n=================================");
        System.out.println("           Department Menu               ");
        System.out.println("=================================");
        System.out.println("1.Print Department");
        System.out.println("2.Print all Departments");
        System.out.println("3.Add Department");
        System.out.println("4.Update Department");
        System.out.println("5.Remove Department");
        System.out.println("6.Connect Course to Department");
        System.out.println("7.Disconnect Course from Department");
        System.out.println("8.Connect Teacher to Department");
        System.out.println("9.Disconnect Teacher from Department");

        System.out.println("\n0.Exit");
        System.out.println("=================================");

    }

    public static void departmentMenu(int choice) {

        switch (choice) {

            case 1:

                break;

            case 0:
                departmentMenuLoop = false;
                Main.emf.close();
                break;

            default:
                System.out.println("No such choice. Try again!");
        }
    }

    public static void statisticsMenu() {

    }

}

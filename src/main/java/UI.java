import management.StudentManager;
import management.CourseManagement;

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
                System.out.print("student id:");
                int id = sc.nextInt();
                sc.nextLine();

                StudentManager.printStudentById(id);
                break;

            case 2:
                StudentManager.printAllStudents();
                break;

            case 3:
                System.out.print("name:");
                String name = sc.nextLine();

                System.out.print("gender:");
                String gender = sc.nextLine();

                System.out.print("age:");
                int age = sc.nextInt();
                sc.nextLine();

                StudentManager.createStudent(name,gender,age);
                break;

            case 4:
                System.out.print("id of the student you wish to update:");
                id = sc.nextInt();
                sc.nextLine();

                StudentManager.updateStudentMenu(id);
                break;

            case 5:

                break;

            case 6:
                System.out.print("id of student:");
                id = sc.nextInt();

                System.out.print("id of course:");
                int courseid = sc.nextInt();
                sc.nextLine();

                CourseManagement.addStudentToCourse(id, courseid);
                break;

            case 7:
                System.out.print("id of student:");
                id = sc.nextInt();

                System.out.print("id of course:");
                courseid = sc.nextInt();
                sc.nextLine();

                CourseManagement.removeStudentFromCourse(id, courseid);
                break;

            case 0:
                studentMenuLoop = false;
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
                CourseManagement.printCourse(id);
                break;

            case 2:
                CourseManagement.printAllCourses();
                break;

            case 3:
                System.out.println("Name of new Course:");
                String name = sc.nextLine();
                CourseManagement.addCourse(name);
                break;

            case 4:
                System.out.println("Id of Course?");
                int idToChange = sc.nextInt();
                sc.nextLine();
                System.out.println("New name of Course?");
                String newName = sc.nextLine();
                CourseManagement.updateCourse(newName, idToChange);
                break;

            case 5:
                System.out.println("Id of Course?");
                int idToRemove = sc.nextInt();
                sc.nextLine();
                CourseManagement.removeCourse(idToRemove);
                break;

            case 6:
                System.out.println("Id of Student to add to Course?");
                int addStudent = sc.nextInt();
                sc.nextLine();
                System.out.println("Id of Course to add Student to?");
                int addToCourse = sc.nextInt();
                sc.nextLine();
                CourseManagement.addStudentToCourse(addStudent, addToCourse);
                break;

            case 7:
                System.out.println("Id of Student to remove from Course?");
                int removeStudent = sc.nextInt();
                sc.nextLine();
                System.out.println("Id of Course to remove Student from?");
                int removeStudentFromCourse = sc.nextInt();
                sc.nextLine();
                CourseManagement.removeStudentFromCourse(removeStudent, removeStudentFromCourse);
                break;

            case 8:
                System.out.println("Id of Teacher to add to Course?");
                int addTeacher = sc.nextInt();
                sc.nextLine();
                System.out.println("Id of Course to add Teacher to?");
                int addTeacherToCourse = sc.nextInt();
                sc.nextLine();
                CourseManagement.addTeacherToCourse(addTeacher, addTeacherToCourse);
                break;

            case 9:

                System.out.println("Id of Course to remove Teacher from?");
                int removeTeacherFromCourse = sc.nextInt();
                sc.nextLine();
                CourseManagement.removeTeacherFromCourse(removeTeacherFromCourse);
                break;

            case 0:
                courseMenuLoop = false;

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

    public static void printTeacherMenu() {

        System.out.println("1.Print Teacher by id");
        System.out.println("2.Print Teacher and course");
        System.out.println("3.Print Teacher and department");

        int printChoice = sc.nextInt();
        sc.nextLine();

        switch (printChoice) {

            case 1:
                TeacherManagement.printTeacherById();
                break;

            case 2:
                TeacherManagement.printTeacherAndCourse();
                break;

            case 3:
                TeacherManagement.printTeacherAndDepartment();
                break;
        }

    }

    public static void teacherMenu(int choice) {

        switch (choice) {

            case 1:
                printTeacherMenu();
                break;


            case 2:
                TeacherManagement.printAllTeachers();
                break;

            case 3:
                TeacherManagement.addTeacher();
                break;

            case 4:
                updateTeacherMenu();
                break;

            case 5 :
                TeacherManagement.removeTeacher();
                break;

            case 6 : TeacherManagement.connectTeacherToCourse();
            break;
            case 0:
                teacherMenuLoop = false;

                break;

            default:
                System.out.println("No such choice. Try again!");
        }
    }

    private static void updateTeacherMenu() {

        System.out.println("1. Update all fields");
        System.out.println("2. Update name");
        System.out.println("3. Update age");
        System.out.println("4. Update gender");
        System.out.println("5. Update salary");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                TeacherManagement.updateAllFields();
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

                break;

            default:
                System.out.println("No such choice. Try again!");
        }
    }

    public static void statisticsMenu() {

    }

}

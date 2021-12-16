import management.DepartmentManager;
import Entity.Teacher;
import Entity.*;
import management.StudentManager;
import management.CourseManagement;
import management.TeacherManagement;


import java.util.Scanner;



public class UI {

    static Scanner sc = new Scanner(System.in);
    static boolean mainMenuLoop = true;
    static boolean studentMenuLoop = true;
    static boolean courseMenuLoop = true;
    static boolean teacherMenuLoop = true;
    static boolean departmentMenuLoop = true;
    static boolean statisticsMenuLoop = true;
    static boolean departmentMenuStatisticLoop = true;
    static boolean courseStatisticsMenuLoop = true;

    public static void menuLoop() {

        mainMenuLoop = true;

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

                studentMenuLoop = true;

                while (studentMenuLoop) {
                    studentMenuUI();

                    System.out.print("\nMake your choice:");
                    int a = sc.nextInt();
                    sc.nextLine();

                    studentMenu(a);
                }
                break;

            case 2:

                courseMenuLoop = true;

                while (courseMenuLoop) {
                    courseMenuUI();

                    System.out.print("\nMake your choice:");
                    int a = sc.nextInt();
                    sc.nextLine();

                    courseMenu(a);
                }
                break;

            case 3:

                teacherMenuLoop = true;

                while (teacherMenuLoop) {
                    teacherMenuUi();

                    System.out.print("\nMake your choice:");
                    int a = sc.nextInt();
                    sc.nextLine();

                    teacherMenu(a);
                }
                break;

            case 4:

                departmentMenuLoop = true;

                while (departmentMenuLoop) {
                    departmentMenuUi();

                    System.out.print("\nMake your choice:");
                    int a = sc.nextInt();
                    sc.nextLine();

                    departmentMenuUi(a);
                }
                break;

            case 5:

                statisticsMenuLoop = true;

                while (statisticsMenuLoop) {
                    statisticsMenuUi();

                    System.out.print("\nMake your choice:");
                    int a = sc.nextInt();
                    sc.nextLine();

                    statisticsMenu(a);

                }
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

                StudentManager.createStudent(name, gender, age);
                break;

            case 4:
                System.out.print("Id of student:");
                id = sc.nextInt();
                sc.nextLine();

                StudentManager.updateStudentMenu(id);
                break;

            case 5:
                System.out.print("Id of student:");
                id = sc.nextInt();
                sc.nextLine();
                StudentManager.removeStudent(id);
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

    public static void teacherMenuUi() {

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
                TeacherManagement.printTeacherMenu();
                break;

            case 2:
                TeacherManagement.printAllTeachers();
                break;

            case 3:
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
                TeacherManagement.addTeacher(teacher);
                break;

            case 4:
                TeacherManagement.updateTeacherMenu();
                break;

            case 5:
                TeacherManagement.printAllTeachers();
                System.out.println("Teacher id:");
                int tId = UI.sc.nextInt();
                UI.sc.nextLine();
                TeacherManagement.removeTeacherById(tId);
                break;

            case 6:
                TeacherManagement.connectTeacherToCourse();
                break;

            case 7:

                TeacherManagement.printAllTeachersAndTheirCourse();
                System.out.println("Teacher id:");
                int teacherId = sc.nextInt();
                sc.nextLine();
                TeacherManagement.disconnectTeacherFromCourse(teacherId);

                break;

            case 8:

                TeacherManagement.connectTeacherToDepartment();
                break;

            case 9:

                TeacherManagement.disconnectTeacherFromDepartment();
                break;

            case 0:
                teacherMenuLoop = false;

                break;

            default:
                System.out.println("No such choice. Try again!");
        }
    }


    public static void departmentMenuUi() {
        System.out.println("\n=================================");
        System.out.println("           Department Menu               ");
        System.out.println("=================================");
        System.out.println("1.Print Department");
        System.out.println("2.Create department");
        System.out.println("3.Update Department");
        System.out.println("4.Remove Department");
        System.out.println("5.Connect Course to Department");
        System.out.println("6.Disconnect Course from Department");
        System.out.println("7.Connect Teacher to Department");
        System.out.println("8.Disconnect Teacher from Department");
        System.out.println("\n0. Return to the main menu");
        System.out.println("=================================");

    }

    public static void departmentMenuUi(int choice) {
        DepartmentManager departmentManager = new DepartmentManager();
        switch (choice) {

            case 1:
                departmentManager.printAllDepartment();
                break;

            case 2:
                departmentManager.createDepartment();
                break;

            case 3:
                departmentManager.updateDepartment();
                break;

            case 4:
                departmentManager.removeDepartment();
                break;

            case 5:
                departmentManager.addCourseToDepartment();
                break;

            case 6:
                departmentManager.removeCourseFromDepartment();

            case 7:
                departmentManager.addTeacherToDepartment();
                break;

            case 8:
                departmentManager.removeTeacherToDepartment();
                break;


            case 0:
                departmentMenuLoop = false;

                break;

            default:
                System.out.println("No such choice. Try again!");
        }
    }

    public static void statisticsMenuUi() {

        System.out.println("\n=================================");
        System.out.println("         Statistics Menu               ");
        System.out.println("=================================");
        System.out.println("1.Student Statistics");
        System.out.println("2.Teacher Statistics");
        System.out.println("3.Course Statistics");
        System.out.println("4.Department Statistics");

        System.out.println("\n0.Exit");
        System.out.println("=================================");

    }


    public static void statisticsMenu(int choice) {

        statisticsMenuLoop = true;

        switch (choice) {

            case 1:
                StudentManager.studentStatistics();
                break;

            case 2:
                TeacherManagement.teacherStatisticsMenu();
                break;

            case 3:
                courseStatisticsMenuLoop = true;

                courseStatisticsMenuLoop();

                break;

            case 4:
                departmentMenuLoop = true;
                departmentUiStat();
                break;




            case 0:
                statisticsMenuLoop = false;

                break;

            default:
                System.out.println("No such choice. Try again!");
        }
    }

    public static void courseStatisticsUi() {


        System.out.println("\n=======================================");
        System.out.println("           Course Statistics             ");
        System.out.println("=========================================");
        System.out.println("1.Display all courses");
        System.out.println("2.Display statistics for specific course");

        System.out.println("\n0.Exit");
        System.out.println("=================================");

    }

    public static void courseStatisticsMenuLoop() {

        courseStatisticsMenuLoop = true;

        while (courseStatisticsMenuLoop) {
            courseStatisticsUi();

            System.out.print("\nMake your choice:");
            int choice = sc.nextInt();
            sc.nextLine();

            courseStatisticsMenu(choice);
        }
    }

    public static void courseStatisticsMenu(int choice) {
        switch (choice) {

            case 1:
                management.CourseManagement.displayAllCourses();
                break;

            case 2:
                System.out.print("\nId?");
                int id = sc.nextInt();
                sc.nextLine();
                management.CourseManagement.displaySpecificCourse(id);
                break;

            case 0:
                courseStatisticsMenuLoop = false;
                break;
        }
    }


    public static void depStatUi() {


        System.out.println("\n=======================================");
        System.out.println("           Department Statistics             ");
        System.out.println("=========================================");
        System.out.println("1.Display all department");
        System.out.println("2.Display statistics for specific course");

        System.out.println("\n0.Return to the main menu");
        System.out.println("=================================");

    }

    public static void departmentUiStat() {

        courseStatisticsMenuLoop = true;

        while (courseStatisticsMenuLoop) {
            depStatUi();

            System.out.print("\nMake your choice:");
            int choice = sc.nextInt();
            sc.nextLine();

            departmentMenuStats(choice);
        }
    }

    public static void departmentMenuStats(int choice) {
        Department department = new Department();
        DepartmentManager departmentManager = new DepartmentManager();
        switch (choice) {
            case 1:
                System.out.println(department);
                break;

            case 2:
                departmentManager.viewCoursesInASpecificDepartment();
                break;


            case 0:
                departmentMenuStatisticLoop = false;
                break;
        }
    }


}
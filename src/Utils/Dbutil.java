/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Dao.AssignmentDao;
import Dao.CourseDao;
import Dao.StudentDao;
import Dao.TrainerDao;
import Model.Assignment;
import Model.Course;
import Model.Student;
import Model.Trainer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Konstantinos
 */
public class Dbutil {

    private static final String USERNAME = "Konstantinos Andreadis";
    private static final String PASS = "poison87!poison87!";
    private static final String MYSQLURL = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";

    public static Connection getconnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(MYSQLURL, USERNAME, PASS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }

    public static void StartPrivateSchool() {

        System.out.println("Welcome to Coding Bootcamp");
        System.out.println("--------------------------");
        showMenu();
        System.out.print("Enter choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        while (choice != 0) {
            System.out.println("");
            switch (choice) {
                case 1:

                    System.out.println("Please insert the student's first name");
                    String firstName = sc.next();
                    System.out.println("Insert the student's surname");
                    String lastName = sc.next();
                    System.out.println("Insert the student's date of birth"
                            + "\n Type of date: YYYY/MM/DD");
                    String dateOfBirth = sc.next();
                    System.out.println("Add student's tuition fee");
                    Double tuitionFee = sc.nextDouble();
                    Student St1 = new Student(firstName, lastName, dateOfBirth, tuitionFee);
                    StudentDao D1 = new StudentDao();
                    D1.insertStudent(St1);

                    break;

                case 2:

                    System.out.println("Please insert the course's title");
                    String title = sc.next();
                    System.out.println("Insert the course's stream");
                    String stream = sc.next();
                    System.out.println("Insert the course's type");
                    String type = sc.next();
                    System.out.println("Insert the course's start date"
                    + "\n Type of date: YYYY/MM/DD");
                    String startDate = sc.next();
                    System.out.println("Insert the course's end date"
                    + "\n Type of date: YYYY/MM/DD");
                    String endDate = sc.next();

                    Course cour = new Course(title, stream, type, startDate, endDate);
                    CourseDao cour1 = new CourseDao();
                    cour1.insertCourse(cour);

                    break;

                case 3:
                    System.out.println("Please insert the trainer's first name");
                    String trfirstName = sc.next();
                    System.out.println("Insert the trainer's last name");
                    String trlastName = sc.next();
                    System.out.println("Insert the trainer's subject");
                    String trsubject = sc.next();
                    Trainer tr1 = new Trainer (trfirstName, trlastName, trsubject);
                    TrainerDao tr2 = new TrainerDao();
                    tr2.insertTrainer(tr1);
                    break;

                case 4:
                  System.out.println("Please insert Assignment's title");
                    String astitle = sc.next();
                    System.out.println("Insert Assignment's description");
                    String description = sc.next();
                    System.out.println("Insert Assignment's sub date time"
                    + "\n Type of date: YYYY/MM/DD");
                    String subDateTime = sc.next();
                    System.out.println("Insert Assignment's oral mark");
                    double oralMark = sc.nextDouble();
                    System.out.println("Insert Assignment's total mark");
                    double totalMark = sc.nextDouble();

                    Assignment assi = new Assignment (astitle, description, subDateTime, oralMark, totalMark);
                    AssignmentDao assi2 = new AssignmentDao();
                    assi2.insertAssignment(assi);
                    break;

                case 5:
                    StudentDao s1 = new StudentDao();
                    System.out.println(s1.getAllStudents());

                    break;

                case 6:
                    CourseDao c1 = new CourseDao();
                    System.out.println(c1.getAllCourses());

                    break;
                case 7:
                    TrainerDao t1 = new TrainerDao();
                    System.out.println(t1.getAllTrainers());

                    break;
                case 8:
                    AssignmentDao a1 = new AssignmentDao();
                    System.out.println(a1);
                    break;
                case 9:
                    StudentDao s2 = new StudentDao();
                    s2.getStudentPerCourse();
                    break;

                case 10:
                    TrainerDao t2 = new TrainerDao();
                    t2.getTrainerPerCourse();
                    break;

                case 11:
                    AssignmentDao a2 = new AssignmentDao();
                    a2.getAssignmemntPerCourse();
                    break;

                case 12:
                    AssignmentDao a3 = new AssignmentDao();
                    a3.getAssignmentsPerStudentPerCourse();
                    break;

                case 13:
                    StudentDao s3 = new StudentDao();
                    s3.getStudentsWithMoreCourses();
                    break;

                case 99:
                    showMenu();
                    break;
            }

            System.out.print("Enter choice (99 to show menu): ");
            choice = sc.nextInt();
        }

    }

    public static void showMenu() {
        System.out.println("");
        System.out.println("1. to add a Student");
        System.out.println("2. to add a Course");
        System.out.println("3. to add a Trainer");
        System.out.println("4. to add a Assignment");
        System.out.println("5. to output a list of all the Students");
        System.out.println("6. to output a list of all the Courses");
        System.out.println("7. to output a list of all the Trainers");
        System.out.println("8. to output a list of all the Assignments");
        System.out.println("9. to output a list of Students per Course");
        System.out.println("10. to output a list of Trainers per Course");
        System.out.println("11. to output a list of Assignments per Course");
        System.out.println("12. to output a list of Assignments per Student");
        System.out.println("13. to output a list of Students that belong to more than one Courses");
        System.out.println("0. to exit");
    }
}

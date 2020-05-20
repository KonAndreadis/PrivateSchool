/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Student;
import Utils.Dbutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Konstantinos
 */
public class StudentDao {

    public  static void insertStudent(Student student) {
        String sql = "insert into student values(null,?,?,?,?)";
        System.out.println(sql);
        Connection con = Dbutil.getconnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getDateOfBirth());
            ps.setDouble(4, student.getTutionFees());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Student> getAllStudents() {
        List<Student> result = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT";
        Connection con = Dbutil.getconnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Student temp = new Student();
                temp.setStudentId(rs.getInt(1));
                temp.setFirstName(rs.getString(2));
                temp.setLastName(rs.getString(3));
                temp.setDateOfBirth(rs.getString(4));
                temp.setTutionFees(rs.getDouble(5));

                result.add(temp);

            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return result;
    }

    public void getStudentPerCourse() {
        String sql = "SELECT STUDENT_FIRST_NAME, STUDENT_LAST_NAME , COURSE_TITLE, COURSE_STREAM , COURSE_TYPE FROM STUDENT S, COURSE C , STUDENT_PER_COURSE SP WHERE S.STUDENT_ID = SP.STUDENT_ID AND C.COURSE_ID = SP.COURSE_ID;";
        Connection con = Dbutil.getconnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print("-Student First Name: " + rs.getString(1) + " -");
                System.out.print("-student Last Name: " + rs.getString(2) + " -");
                System.out.print("-Course Title: " + rs.getString(3) + " -");
                System.out.print("-Course Stream: " + rs.getString(4) + " -");
                System.out.print("Course Type: " + rs.getString(5) + " ");
                System.out.println("");
            }
        } catch (SQLException e) {
        }
    }

    public void getStudentsWithMoreCourses() {
        String sql = "SELECT S.STUDENT_FIRST_NAME, S.STUDENT_LAST_NAME, COUNT(DISTINCT R.COURSE_ID) AS NUM_COUR FROM STUDENT S  LEFT JOIN STUDENT_PER_COURSE R ON R.STUDENT_ID = S.STUDENT_ID GROUP BY S.STUDENT_ID HAVING NUM_COUR >= 2;";
        Connection con = Dbutil.getconnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print("-Student First Name: " + rs.getString(1) + " -");
                System.out.print("-Stusent Last Name: " + rs.getString(2) + " -");
                System.out.print("-Number of Courses: " + rs.getString(3) + " -");
                System.out.println("");
            }
        } catch (SQLException e) {
        }
    }
}

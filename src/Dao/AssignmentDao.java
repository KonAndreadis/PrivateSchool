/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Assignment;
import Utils.Dbutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Konstantinos
 */
public class AssignmentDao {

    public void insertAssignment(Assignment assignment) {
        String sql = "insert into assignment values(null,?,?,?,?,?)";
        System.out.println(sql);
        Connection con = Dbutil.getconnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, assignment.getTitle());
            ps.setString(2, assignment.getDescription());
            ps.setString(3, assignment.getSubDateTime());
            ps.setDouble(4, assignment.getOralMark());
            ps.setDouble(5, assignment.getTotalMark());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Assignment> getAllAssignments() {
        List<Assignment> result = new ArrayList<>();
        String sql = "SELECT * FROM ASSIGNMENT";
        Connection con = Dbutil.getconnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Assignment temp = new Assignment();
                temp.setAssignmentId(rs.getInt(1));
                temp.setTitle(rs.getString(2));
                temp.setDescription(rs.getString(3));
                temp.setSubDateTime(rs.getString(4));
                temp.setOralMark(rs.getDouble(5));
                temp.setTotalMark(rs.getDouble(6));

                result.add(temp);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return result;
    }

    public void getAssignmemntPerCourse() {
        String sql = "SELECT ASSIGNMENT_TITLE, DESCRIPTION_ , COURSE_TITLE, COURSE_STREAM , COURSE_TYPE FROM ASSIGNMENT A, COURSE C , ASSIGNMENT_PER_COURSE AP WHERE A.ASSIGNMENT_ID = AP.ASSIGNMENT_ID AND C.COURSE_ID = AP.COURSE_ID;";
        Connection con = Dbutil.getconnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print("-Assignment Title: " + rs.getString(1) + " -");
                System.out.print("-Assignment Description: " + rs.getString(2) + " -");
                System.out.print("-Course Title: " + rs.getString(3) + " -");
                System.out.print("-Course Stream: " + rs.getString(4) + " -");
                System.out.print("Course Type: " + rs.getString(5) + " ");
                System.out.println("");
            }
        } catch (SQLException e) {
        }
    }

    public void getAssignmentsPerStudentPerCourse() {
        String sql = "SELECT STUDENT_FIRST_NAME , STUDENT_LAST_NAME , ASSIGNMENT_TITLE , DESCRIPTION_ ,COURSE_STREAM , COURSE_TYPE FROM STUDENT S , COURSE C , ASSIGNMENT A ,  STUDENT_PER_COURSE SP , ASSIGNMENT_PER_COURSE AP WHERE S.STUDENT_ID = SP.STUDENT_ID AND  A.ASSIGNMENT_ID = AP.ASSIGNMENT_ID AND C.COURSE_ID = SP.COURSE_ID AND C.COURSE_ID = AP.COURSE_ID ORDER BY STUDENT_LAST_NAME;";
        Connection con = Dbutil.getconnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print("-Student First Name: " + rs.getString(1) + " -");
                System.out.print("-Student Last Name: " + rs.getString(2) + " -");
                System.out.print("-Assignment Title: " + rs.getString(3) + " -");
                System.out.print("-Assignment Description: " + rs.getString(4) + " -");
                System.out.print("-Course Stream: " + rs.getString(5) + " -");
                System.out.print("-Course Type: " + rs.getString(6) + " -");
                System.out.println("");
            }
        } catch (SQLException e) {
        }
    }

}

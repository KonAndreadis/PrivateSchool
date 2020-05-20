/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Course;
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
public class CourseDao {

    public void insertCourse(Course course) {
        String sql = "insert into course values(null,?,?,?,?,?)";
        System.out.println(sql);
        Connection con = Dbutil.getconnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, course.getTitle());
            ps.setString(2, course.getStream());
            ps.setString(3, course.getType());
            ps.setString(4, course.getStartDate());
            ps.setString(5, course.getEndDate());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Course> getAllCourses() {
        List<Course> result = new ArrayList<>();
        String sql = "SELECT * FROM COURSE";
        Connection con = Dbutil.getconnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Course temp = new Course();
                temp.setCourseId(rs.getInt(1));
                temp.setTitle(rs.getString(2));
                temp.setStream(rs.getString(3));
                temp.setType(rs.getString(4));
                temp.setStartDate(rs.getString(5));
                temp.setEndDate(rs.getString(6));

                result.add(temp);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return result;
    }
}

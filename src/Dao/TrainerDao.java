/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Trainer;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.Dbutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Konstantinos
 */
public class TrainerDao {

    public void insertTrainer(Trainer trainer) {
        String sql = "insert into trainer values(null,?,?,?)";
        System.out.println(sql);
        Connection con = Dbutil.getconnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trainer.getFirstName());
            ps.setString(2, trainer.getLastName());
            ps.setString(3, trainer.getSubject());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Trainer> getAllTrainers() {
        List<Trainer> result = new ArrayList<>();
        String sql = "SELECT * FROM TRAINER";
        Connection con = Dbutil.getconnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Trainer temp = new Trainer();
                temp.setTrainerId(rs.getInt(1));
                temp.setFirstName(rs.getString(2));
                temp.setLastName(rs.getString(3));
                temp.setSubject(rs.getString(4));

                result.add(temp);

            }

        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return result;
    }

    public void getTrainerPerCourse() {
        String sql = "SELECT TRAINER_FIRST_NAME, TRAINER_LAST_NAME , COURSE_TITLE, COURSE_STREAM , COURSE_TYPE FROM TRAINER T, COURSE C , TRAINER_PER_COURSE TP WHERE T.TRAINER_ID = TP.TRAINER_ID AND C.COURSE_ID = TP.COURSE_ID;";
        Connection con = Dbutil.getconnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print("-Trainer First Name: " + rs.getString(1) + " -");
                System.out.print("-Trainer Last Name: " + rs.getString(2) + " -");
                System.out.print("-Course Title: " + rs.getString(3) + " -");
                System.out.print("-Course Stream: " + rs.getString(4) + " -");
                System.out.print("Course Type: " + rs.getString(5) + " ");
                System.out.println("");
            }
        } catch (SQLException e) {
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Konstantinos
 */
public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private double tutionFees;
    //private List<Course> courses;

    public Student() {
    }

    public Student(String firstName, String lastName, String dateOfBirth, double tutionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tutionFees = tutionFees;
    }
 
   

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getTutionFees() {
        return tutionFees;
    }

    public void setTutionFees(double tutionFees) {
        this.tutionFees = tutionFees;
    }

    // public List<Course> getCourses() {
    //   return courses;
    // public void setCourses(List<Course> courses) {
    //    this.courses = courses;
    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", tutionFees=" + tutionFees + '}';
    }

}

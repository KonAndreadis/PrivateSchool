/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Konstantinos
 */
public class Trainer {
       private int trainerId;
       private String firstName;
    private String lastName;
    private String subject;

 

    public Trainer() {
    }

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

   
    

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
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

    public int getTrainerId() {
        return trainerId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

   // public Course getCourse() {
   //     return course;
  // }

   //public void setCourse(Course course) {
   //     this.course = course;
   //}

    @Override
    public String toString() {
        return "Trainer{" + "trainerId=" + trainerId + ", firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject + '}';
    }


    
    

   
        
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataManagement;

import java.io.*;
import java.util.List;

/**
 *
 * @author Salma
 */
public class Person implements Serializable{
    private static final long serialVersionUID = 1169519102209510411L;

    private String ID;
    private String name;
    private String phone;
    private String email;
    private String password;
    
    public Person(String ID, String name, String phone, String email, String password) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
    
    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }   

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public static <UserType> Person getPersonByEmail(String fileName,String patientEmail, UserType user) {
        List<Person> userList = (List<Person>) Admin.loadPersons(fileName, Person.class);

        for (Person patient : userList) {
            // Assuming there is a method getPatientID() in UserType
            if (patient instanceof Person && ((Person) patient).getEmail().equals(patientEmail)) {
                // Display patient record or perform any other actions
                System.out.println("Found User: " + patient.getName());
                return patient;
            }
        }
        // Patient not found
        System.out.println("User with email " + patientEmail + " not found.");
        return null;
    }

    public static boolean login(List<? extends Person> persons, String email, String password) {
        for (Person person : persons) {
            if (person.getEmail().equals(email) && (person.getPassword().equals(password))) {
                System.out.println("Login successful for " + person.getName());
                return true;
            }
        }
        System.out.println("Login failed. Incorrect email or password.");
        return false;
    }
    
    public static boolean foregetPass(List<? extends Person> persons, String email, String newPassword) {
        for (Person person : persons) {
            if (person.getEmail().equals(email)) {
                person.setPassword(newPassword);
                System.out.println(person.getName()+ "'s password reset successful.");
                return true;
            }
        }
        System.out.println("Invalid email. Password reset failed.");
        return false;
    }

    public static void logout() {    
        System.out.println("Logged out successfully!");
    }
    
}  
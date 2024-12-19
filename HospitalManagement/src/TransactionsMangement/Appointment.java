/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransactionsMangement;

/**
 *
 * @author Salma
 */
import DataManagement.Admin;
import DataManagement.Doctor;
import DataManagement.Nurse;
import DataManagement.Patient;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Appointment implements Serializable {
    
    private static final long serialVersionUID = 4917711569735325077L;
    
    protected String appointmentID;
    private LocalDate appointmentDateTime;
    protected Doctor doctor;
    protected Nurse nurse;
    protected Patient patient;
    public String roomNumber;
    private List<Feedback> feedbackList;

    // Constructor
    public Appointment(String appointmentID, LocalDate appointmentDateTime, Doctor doctor, Nurse nurse, Patient patient, String roomNumber) {
        this.appointmentID = appointmentID;
        this.appointmentDateTime = appointmentDateTime;
        this.doctor = doctor;
        this.nurse = nurse;
        this.patient = patient;
        this.roomNumber = roomNumber;
        this.feedbackList = new ArrayList<>();
    }

    // Getter and Setter methods for attributes

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public LocalDate getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDate appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public Doctor getDoctorID() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public static Appointment getAppointmentById(String appointmentID) {
        List<Appointment> existingAppointments = (List<Appointment>) Admin.loadItems("appointments.dat", Appointment.class);
            for (Appointment appointment : existingAppointments) {
                if (appointment.getAppointmentID().equals(appointmentID)) {
                    return appointment;
                }
            }
        System.out.println("Appointment Not Found");
        return null;
    }

    public String reschedule(LocalDate newAppointmentDateTime) {
        String result = null;
        if (newAppointmentDateTime.isBefore(this.appointmentDateTime)) {
            this.appointmentDateTime = newAppointmentDateTime;
            System.out.println("Appointment rescheduled successfully for ID " + this.appointmentID);
            result = "Appointment rescheduled successfully for ID " + this.appointmentID;
        } else {
            System.out.println("Invalid reschedule for appointment ID " + this.appointmentID);
            result = "Invalid reschedule for appointment ID " + this.appointmentID;
        }
        return result;
    }

    public void provideFeedback(Feedback feedback) {
        Admin.storeInFile("feedbacks.dat", Feedback.class);
        feedbackList.add(feedback);
        System.out.println("Feedback provided successfully for appointment ID " + this.appointmentID);
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }
    
    public static List<String> readAppIdsFromFile(String filePath) {
      List<String> ids = new ArrayList<>();

      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
          List<Appointment> appointments = (List<Appointment>) ois.readObject();

          for (Appointment appointment : appointments) {
              ids.add(appointment.getAppointmentID());
          }
      } catch (IOException | ClassNotFoundException e) {
          ids.add("empty");
      }

      return ids;
    } 
    

    @Override
    public String toString() {
        return "Appointment{" + "appointmentID=" + appointmentID + ", appointmentDateTime=" + appointmentDateTime + ", doctor=" + doctor + ", nurse=" + nurse + ", patient=" + patient + ", feedbackList=" + feedbackList + '}';
    }
    
}

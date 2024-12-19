/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransactionsMangement;

import DataManagement.Admin;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Salma
 */
public class Prescription implements Serializable{

    public String prescriptionID;
    private String appointmentID;
    private HashMap<String, String> medicationAndDuration;
    private Double amount;

    public Prescription(String prescriptionID, String appointmentID, HashMap<String, String> medicationAndDuration) {
        this.prescriptionID = prescriptionID;
        this.appointmentID = appointmentID;
        this.medicationAndDuration = medicationAndDuration;
    }



    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPrescriptionID() {
        return prescriptionID;
    }

    public String getappointmentID() {
        return appointmentID;
    }

    public HashMap<String, String> getMedicationAndDuration() {
        return medicationAndDuration;
    }
    
    public static Prescription getPrescriptionById(String prescriptionID) {
        List<Prescription> existingPrescriptions = (List<Prescription>) Admin.loadItems("prescriptions.dat", Prescription.class);
            for (Prescription prescription : existingPrescriptions) {
                if (prescription.getPrescriptionID() .equals(prescriptionID)) {
                    return prescription;
                }
            }
        System.out.println("Room Not Find");
        return null;
    }

    public void addMedication(String medication, String duration) {
        medicationAndDuration.put(medication, duration);
    }
 
    public static List<String> readPrescIdsFromFile() {
      List<String> ids = new ArrayList<>();

      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("prescriptions.dat"))) {
          List<Prescription> prescriptions = (List<Prescription>) ois.readObject();

          for (Prescription prescription : prescriptions) {
              ids.add(prescription.getPrescriptionID());
          }
      } catch (IOException | ClassNotFoundException e) {
          ids.add("empty");
      }

      return ids;
    } 

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionID='" + prescriptionID + '\'' +
                ", appointmentID='" + appointmentID + '\'' +
                ", medicationAndDuration=" + medicationAndDuration +
                '}';
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataManagement;

import TransactionsMangement.Prescription;
import java.io.*;
import java.util.List;

/**
 *
 * @author Salma
 */
public class Patient extends Person implements Serializable{
    private static final long serialVersionUID = -1585287596665717443L;
        
    public int age;
    public String gender;
    public MedicalRecord medicalRecord;

    public Patient(String ID, String name, String phone, String email, String password, int age, String gender, String medicalRecordID, 
            String pastMedicalConditions, String allergy, String vaccination, String labTest, String surgery) {
        super(ID,name, phone, email, password);
        this.age = age;
        this.gender = gender;
        this.medicalRecord = new MedicalRecord();
        createMedicalRecord(medicalRecordID, pastMedicalConditions, allergy, vaccination, labTest, surgery);

    }  
   
    public <UserType> void createMedicalRecord(String medicalRecordID, String pastMedicalConditions, String allergy, String vaccination, String labTest, String surgery) {
        medicalRecord.setPatientID(this.getID());
        medicalRecord.addPastMedicalConditions(pastMedicalConditions);
        medicalRecord.addAllergy(allergy);
        medicalRecord.addVaccination(vaccination);       
        medicalRecord.addLabTests(labTest);
        medicalRecord.addSurgeries(surgery);  
        System.out.println("Medical record created for patient " + this.getID());
    }

    public MedicalRecord getMedicalRecord(){
        return medicalRecord ;
    }

    public static <UserType> String getPrescription(String filePath, UserType user, String appointmentID) {

        List<Prescription> prescriptions = (List<Prescription>) Admin.loadItems(filePath, Prescription.class);
        
        for (Prescription prescription : prescriptions) {
            if (prescription.getappointmentID().equals(appointmentID)) {
                return prescription.toString(); // Found matching prescription
            }
        }
        return null; // No matching prescription found
    }
    public static Patient getPatientByID(String personID) {
        List<Patient> userList = (List<Patient>) Admin.loadPersons("patients.dat", Patient.class);

        for (Patient patient : userList) {
            // Assuming there is a method getPatientID() in UserType
            if (patient instanceof Patient && ((Patient) patient).getID().equals(personID)) {
                // Display patient record or perform any other actions
                System.out.println("Found User: " + patient.getName());
                return patient;
            }
        }
        // Patient not found
        System.out.println("User with person " + personID + " not found.");
        return null;
    }
      
    @Override
    public String toString() {
        return "Patient{" +
                "PatientID='" + this.getID() + '\'' +
                ", Patient Name=" + this.getName() +
                ", Patient Email=" + this.getEmail() +
                ", Patient Password=" + this.getPassword() +
                ", Patient age=" + age +
                ", Patient gender=" + gender +
                '}';
    }
}

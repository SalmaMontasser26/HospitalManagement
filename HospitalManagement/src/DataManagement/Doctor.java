/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataManagement;

import TransactionsMangement.Prescription;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author Salma
 */
public class Doctor extends Person implements iMedicalStaff{
    
    private static final long serialVersionUID = -5045244719701274775L;
    
    public String specialization;
    public String department;    
    
    public Doctor(String ID, String name, String phone, String email, String password, String specialization, String department) {
        super(ID, name, phone, email, password);
        this.specialization = specialization;
        this.department = department;
    }
    
    @Override
    public String writePrescription(Prescription prescription, HashMap<String, String> medicationsAndDurations) {
        prescription.getMedicationAndDuration().putAll(medicationsAndDurations);
        Admin.storeInFile("prescriptions.dat", prescription);
        System.out.println("Prescription written by doctor:\n" + prescription);
        String result = "Prescription written by doctor:\n" + prescription;
        return result;
    }


    
    @Override
    public <UserType> String getPatientRecordByID(String patientID, UserType user) {
        List<MedicalRecord> userList = (List<MedicalRecord>) Admin.loadItems("medicalRecord.dat", MedicalRecord.class);

        for (MedicalRecord medicalRecord : userList) {
            // Assuming there is a method getPatientID() in UserType
            if (medicalRecord instanceof MedicalRecord && ((MedicalRecord) medicalRecord).getPatientID().equals(patientID)) {
                // Display patient record or perform any other actions
                System.out.println("Found patient: " + medicalRecord.toString());
                return medicalRecord.toString();
            }
        }
        // Patient not found
        System.out.println("Patient with ID " + patientID + " not found.");
        return null;
    }
    
    public static Doctor getDoctorByID(String personID) {
        List<Doctor> userList = (List<Doctor>) Admin.loadPersons("doctors.dat", Doctor.class);

        for (Doctor patient : userList) {
            // Assuming there is a method getPatientID() in UserType
            if (patient instanceof Doctor && ((Doctor) patient).getID().equals(personID)) {
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
        return "Doctor{" +
                "DoctorID='" + this.getID() + '\'' +
                ", Doctor Name=" + this.getName() +
                ", Doctor Email=" + this.getEmail() +
                ", Doctor Password=" + this.getPassword() +
                ", Doctor Specialization=" + specialization +
                ", Doctor Department=" + department +
                '}';
    }
  
}

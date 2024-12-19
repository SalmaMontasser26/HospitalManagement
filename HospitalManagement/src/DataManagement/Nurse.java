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
public class Nurse extends Person implements iMedicalStaff{
    
    private static final long serialVersionUID = -3551955998821115010L;
    
    public int nursingLicenseNumber;
    public String shift;
    
    public Nurse(String ID, String name, String phone, String email, String password, int nursingLicenseNumber, String shift) {
        super(ID, name, phone, email, password);
        this.nursingLicenseNumber = nursingLicenseNumber;
        this.shift = shift;
    }
    
    @Override
    public String writePrescription(Prescription prescription, HashMap<String, String> medicationsAndDurations) { 
        String result = null;
        for (String medication : medicationsAndDurations.keySet()) {
            if (prescription.getMedicationAndDuration().containsKey(medication)) {
                prescription.getMedicationAndDuration().put(medication, medicationsAndDurations.get(medication));
                System.out.println("Nurse updated prescription:\n" + prescription);
                result = "Nurse updated prescription:\n" + prescription;
            } else {
                System.out.println("Nurse cannot add new medications. Only updating existing durations allowed.");
                result = "Nurse cannot add new medications. Only updating existing durations allowed.";
            }
        } 
        return result;
    }
   
    @Override
     public <UserType> String getPatientRecordByID(String patientID, UserType user) {
        List<MedicalRecord> userList = (List<MedicalRecord>) Admin.loadItems("medicalRecord.dat", MedicalRecord.class);

        for (MedicalRecord medicalRecord : userList) {
            // Assuming there is a method getPatientID() in UserType
            if (medicalRecord instanceof MedicalRecord && ((MedicalRecord) medicalRecord).getPatientID().equals(patientID)) {
                // Display patient record or perform any other actions
                System.out.println("Found record: " + medicalRecord.getAllergies() + medicalRecord.getVaccinations() );
                String result = "Allergies: " + medicalRecord.getAllergies().toString() + "Vaccinations: " + medicalRecord.getVaccinations().toString();
                return result;
            }
        }
        System.out.println("Record for patient with ID " + patientID + " not found.");
        return null;
    }
     
    public static Nurse getNurseByID(String personID) {
        List<Nurse> userList = (List<Nurse>) Admin.loadPersons("nurses.dat", Nurse.class);

        for (Nurse patient : userList) {
            // Assuming there is a method getPatientID() in UserType
            if (patient instanceof Nurse && ((Nurse) patient).getID().equals(personID)) {
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
        return "Nurse{" +
                "NurseID='" + this.getID() + '\'' +
                ", Nurse Name=" + this.getName() +
                ", Nurse Email=" + this.getEmail() +
                ", Nurse Password=" + this.getPassword() +
                ", Nurse License Number=" + nursingLicenseNumber +
                ", Nurse Shift=" + shift +
                '}';
    }
}
//    @Override
//    public void viewPatientRecord(Patient patient) {
//        MedicalRecord medicalRecord = patient.getMedicalRecord();
//            System.out.println("Patient ID: " + patient.getID());
//            System.out.println("Name: " + patient.getName());
//            System.out.println("Allergies: " + medicalRecord.getPastMedicalConditions());
//            System.out.println("Vaccinations: " + medicalRecord.getVaccinations());
//    }

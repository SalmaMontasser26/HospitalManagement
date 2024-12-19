/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Salma
 */
public class MedicalRecord implements Serializable{
    private String medicalRecordID;
    private String patientID;
    private ArrayList<String> pastMedicalConditions;
    private ArrayList<String> allergies;
    private ArrayList<String> vaccinations;
    private ArrayList<String> labTests;
    private ArrayList<String> surgeries;

    public MedicalRecord() {
        this.medicalRecordID = medicalRecordID;
        this.patientID = patientID;
        this.pastMedicalConditions = new ArrayList<>();
        this.allergies = new ArrayList<>();
        this.vaccinations = new ArrayList<>();
        this.labTests = new ArrayList<>();
        this.surgeries = new ArrayList<>();
    }

 public String getMedicalRecordID(){
       return medicalRecordID;
    }
    public ArrayList<String> getPastMedicalConditions() {
        return pastMedicalConditions;
    }
    
    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public ArrayList<String> getVaccinations() {
        return vaccinations;
    }
    
    public ArrayList<String> getLabTests() {
        return labTests;
    }

    public ArrayList<String> getSurgeries() {
        return surgeries;
    }
    public String getPatientID(){
        return patientID;
    }

    public void setMedicalRecordID(String medicalRecordID) {
        this.medicalRecordID = medicalRecordID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setPastMedicalConditions(ArrayList<String> pastMedicalConditions) {
        this.pastMedicalConditions = pastMedicalConditions;
    }

    public void setAllergies(ArrayList<String> allergies) {
        this.allergies = allergies;
    }

    public void setVaccinations(ArrayList<String> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public void setLabTests(ArrayList<String> labTests) {
        this.labTests = labTests;
    }

    public void setSurgeries(ArrayList<String> surgeries) {
        this.surgeries = surgeries;
    }


    public void addPastMedicalConditions(String pastMedicalCondition) {
        String[] pastMedicalConditionArray = pastMedicalCondition.split(",\\s*");
        this.pastMedicalConditions.addAll(Arrays.asList(pastMedicalConditionArray));    }
    
    public void addAllergy(String allergy) {
        String[] allergyArray = allergy.split(",\\s*");
        this.allergies.addAll(Arrays.asList(allergyArray));
    }

    public void addVaccination(String vaccination) {
        String[] vaccinationArray = vaccination.split(",\\s*");
        this.vaccinations.addAll(Arrays.asList(vaccinationArray));
    }
    
    public void addLabTests(String labTest) {
        String[] labTestArray = labTest.split(",\\s*");
        this.labTests.addAll(Arrays.asList(labTestArray));
    }
    
    public void addSurgeries(String surgery) {
        String[] surgeryArray = surgery.split(",\\s*");
        this.surgeries.addAll(Arrays.asList(surgeryArray));
    }
    
    @Override
    public String toString() {
        return "MedicalRecord{" +
                "patientID='" + patientID + '\'' +
                ", past medical conditions=" + pastMedicalConditions +
                ", allergies=" + allergies +
                ", vaccinations=" + vaccinations +
                ", lab test=" + labTests +
                ", surgeries=" + surgeries +
                '}';
    }
}

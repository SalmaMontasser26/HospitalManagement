/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataManagement;

import TransactionsMangement.Prescription;
import java.util.HashMap;

/**
 *
 * @author Salma
 */
public interface iMedicalStaff {
    
    public String writePrescription(Prescription prescription, HashMap<String, String> medicationsAndDurations);
    public <UserType> String getPatientRecordByID(String patientID, UserType user);
    
}

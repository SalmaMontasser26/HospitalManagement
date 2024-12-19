/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MedicineManagement;

import DataManagement.Person;
import DataManagement.Admin;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Salma
 */
public class Pharmacist extends Person implements Serializable{
    
    private static final long serialVersionUID = -8135259050947518456L;

    
    public int licenseNumber;
    
    public Pharmacist(String ID, String name, String phone, String email, String password, int licenseNumber) {
        super(ID, name, phone, email, password);
        this.licenseNumber = licenseNumber;
    }
    public static void storeMedicine(String filePath, Medicine medicine) {
        Admin.storeInFile(filePath, medicine);
    }
    
    public static <UserType> List<UserType> getAllMedicine(String filePath, UserType user) {
        return (List<UserType>) Admin.loadPersons(filePath, Person.class);

    }  

    public static <UserType> String checkStock(String medicineID, UserType user) {
          List<Medicine> userList = (List<Medicine>) Admin.loadItems("medicine.dat", Medicine.class);

        for (Medicine medicine : userList) {
            // Assuming there is a method getPatientID() in UserType
            if (medicine instanceof Medicine && ((Medicine) medicine).getItemID().equals(medicineID)) {
                // Display patient record or perform any other actions
                String quantity = Integer.toString(medicine.getQuantity());
                System.out.println("Stock for itemID " + medicine.getItemID() + ": " + medicine.getQuantity());
                String result = "Stock for itemID " + medicine.getItemID() + ": " + quantity;
                return result;
            }
        } 
        return null;
    }
    
    public static <UserType> String updateInventory(String medicineID, UserType user, int quantity) {
        List<Medicine> userList = (List<Medicine>) Admin.loadItems("medicine.dat", Medicine.class);
        for (Medicine medicine : userList) {
            // Assuming there is a method getPatientID() in UserType
            if (medicine instanceof Medicine && ((Medicine) medicine).getItemID().equals(medicineID)) {
                // Display patient record or perform any other actions
                medicine.addQuantity(quantity);
                String quantity2 = Integer.toString(medicine.getQuantity());
                System.out.println("Updated inventory for " + medicine.getItemName() + ". Quantity: " + medicine.getQuantity());
                String result = "Updated inventory for " + medicine.getItemID() + ". Quantity: " + quantity2;
                return result;
            }
        }
        return null;
    }
    
    public static <UserType> String checkExpirationDate(String medicineID, UserType user) {
        List<Medicine> userList = (List<Medicine>) Admin.loadItems("medicine.dat", Medicine.class);
        LocalDate currentDate = LocalDate.now();
        String result;
        for (Medicine medicine : userList) {
            // Assuming there is a method getPatientID() in UserType
            if (medicine instanceof Medicine && ((Medicine) medicine).getItemID().equals(medicineID)) {
                // Display patient record or perform any other actions
                if (medicine.getExpirationDate().isBefore(currentDate)) {
                System.out.println("The medicine " + medicine.getItemName() +
                        " has expired on " + medicine.getExpirationDate());
                result = "The medicine " + medicine.getItemID() + "has expired on " + medicine.getExpirationDate().toString() ;
                return result;
                } else {
                System.out.println("The medicine " + medicine.getItemName() +
                        " is not expired. Expiration date: " + medicine.getExpirationDate());
                result = "The medicine " + medicine.getItemName() + " is not expired. Expiration date: " + medicine.getExpirationDate().toString();
                return result;
                }
            }
        }  
        return null;
    }
    
    @Override
    public String toString() {
        return "Pharmacist{" +
                "PharmacistID='" + this.getID() + '\'' +
                ", Pharmacist Name=" + this.getName() +
                ", Pjarmacist Email=" + this.getEmail() +
                ", Pharmacist Password=" + this.getPassword() +
                ", Pharmacist License Number=" + licenseNumber +
                '}';
    }
}

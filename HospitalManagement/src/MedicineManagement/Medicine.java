/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MedicineManagement;


import DataManagement.Admin;
import DataManagement.Person;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salma
 */
public class Medicine implements Serializable{
    private static final long serialVersionUID = -9208542493456323613L;
    private String itemID;
    private String itemName;
    private int quantity;
    private double price;
    private LocalDate expirationDate;

   
    public Medicine(String itemID, String itemName, int quantity, double price, LocalDate expirationDate) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    
    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void addQuantity(int quantityToAdd) {
        this.quantity += quantityToAdd;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }


    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate =  expirationDate;
    }
    
     public static List<String> readMedIdsFromFile() {
        List<String> ids = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("medicine.dat"))) {
            List<Medicine> medicines = (List<Medicine>) ois.readObject();

            for (Medicine medicine : medicines) {
                ids.add(medicine.getItemID());
            }
        } catch (IOException | ClassNotFoundException e) {
            ids.add("empty");
        }

        return ids;
    }
      public static Medicine getMedicineById(String ID) {
        List<Medicine> existingMedicines = (List<Medicine>) Admin.loadItems("medicine.dat", Medicine.class);
            for (Medicine medicine : existingMedicines) {
                if (medicine.getItemID() .equals(ID)) {
                    return medicine;
                }
            }
        System.out.println("Medicine Not Found");
        return null;
    }
    
    @Override
    public String toString() {
        return "Medicine{" +
                "medicineName='" + itemName + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}

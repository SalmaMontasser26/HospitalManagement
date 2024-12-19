/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransactionsMangement;

/**
 *
 * @author Salma
 */
import java.io.*;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Payment implements Serializable{
    private String paymentId;
    private String prescriptionId;
    public Date paymentDate;
    private double amount;
    public String status = "Not Paid";
    public Prescription prescription;

    public Payment(String paymentId, String prescriptionId, Date paymentDate, double amount) {
        this.paymentId = paymentId;
        this.prescriptionId = prescriptionId;
        this.paymentDate = paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void generateReceipt() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println("Receipt for payment of $" + amount);
        System.out.println("Date and Time: " + formattedDateTime);
        System.out.println("Thank you for purchasing!");
    }  

//    private void savePaymentData() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("payment_data.dat"))) {
//            oos.writeObject(this);
//            System.out.println("Payment data saved successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Error saving payment data.");
//        }
//    }
//
//    public static Payment loadPaymentData() {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("payment_data.dat"))) {
//            return (Payment) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("Error loading payment data.");
//            return null;
//        }
//    }
}

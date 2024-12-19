/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransactionsMangement;

import java.util.Date;

/**
 *
 * @author Salma
 */
public class Cash extends Payment{
    private double RecievedAmount;

    public Cash(double RecievedAmount, String paymentId, String prescriptionID, Date paymentDate, double amount) {
        super(paymentId, prescriptionID , paymentDate, amount);
        this.RecievedAmount = RecievedAmount;
        
    }
 
    public void setReceivedAmount(double RecievedAmount) {
    this.RecievedAmount = RecievedAmount;
    }
    public double getRecievedAmount(){
    return RecievedAmount;
    }
   
     public String processPayment(Double amount, Double receivedAmount) {        
         String result = null;
         if (receivedAmount >= amount) {
          
            this.status = "Paid";
            this.paymentDate = new Date(); 
            generateReceipt();
            System.out.println("Payment successful!");

            // Calculate change
            Double change = receivedAmount - amount;
            System.out.println("Change: " + change);
            result = "Payment successful. Your change is: " + String.valueOf(change);
        } else {
            // Insufficient funds
            System.out.println("Insufficient funds. Payment failed.");
        }
         
        return result;

    }



}

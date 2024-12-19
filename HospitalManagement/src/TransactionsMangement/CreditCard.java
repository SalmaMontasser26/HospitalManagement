/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransactionsMangement;

/**
 *
 * @author Salma
 */

import java.time.LocalDate;
import java.util.Date;

public class CreditCard extends Payment{
    private long cardNumber;
    private String cardHolderName;
    private LocalDate expirationDate;
    private int securityCode;

    public CreditCard(long cardNumber, String cardHolderName, LocalDate expirationDate, int securityCode, String paymentId, String prescriptionID, Date paymentDate, double amount) {
        super(paymentId, prescriptionID, paymentDate, amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    
    public void setCardNumber(long cardNumber) {
        String cardNumberString = String.valueOf(cardNumber);

        if (isValidCreditCard(cardNumber) && cardNumberString.substring(1).matches("\\d+")) {
            this.cardNumber = cardNumber; 
        } else {
            System.out.println("Invalid credit card number. Please ensure it has 16 characters, and the last 15 are numeric.");
        }
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setExpirationDate(LocalDate expirationDate) {

        this.expirationDate = expirationDate;
    }

    public void setSecurityCode(int securityCode) {
        if (isValidSecurityCode(securityCode)) {
            this.securityCode = securityCode;
        } else {
            System.out.println("Invalid security code");
        }
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    private boolean isValidCreditCard(long cardNumber) {
        return String.valueOf(cardNumber).length() == 16;
    }

    private boolean isValidSecurityCode(int securityCode) {
        return securityCode >= 100 && securityCode <= 999;
    }

    public void processPayment(Prescription prescription, CreditCard creditCard) {
        System.out.println("Processing credit card payment for Card Holder: " + creditCard.getCardHolderName());
        System.out.println("Credit Card Number: " + creditCard.getCardNumber());

        if (isValidCreditCard(creditCard.getCardNumber())) {
            System.out.println("Credit card is valid.");
        } else {
            System.out.println("Invalid credit card.");
        }

        System.out.println("Charging the amount of $" + creditCard.getAmount());
        System.out.println("Payment processed successfully for prescription ID: " + prescription.getPrescriptionID());
}


}

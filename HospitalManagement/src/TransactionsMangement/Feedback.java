/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransactionsMangement;

import java.io.*;
import java.util.*;

/**
 *
 * @author Salma
 */
public class Feedback implements Serializable{

    private String feedbackID;
    private String appointmentID;
    private Date dataSubmitted;
    private String rating;

    public Feedback(String feedbackID, String appointmentID, Date dataSubmitted, String rating) {
        this.feedbackID = feedbackID;
        this.appointmentID = appointmentID;
        this.dataSubmitted = dataSubmitted;
        this.rating = rating;
    }

    public String getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Date getDataSubmitted() {
        return dataSubmitted;
    }

    public void setDataSubmitted(Date dataSubmitted) {
        this.dataSubmitted = dataSubmitted;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackID=" + feedbackID +
                ", dataSubmitted=" + dataSubmitted +
                ", rating='" + rating + '\'' +
                '}';
    }
}

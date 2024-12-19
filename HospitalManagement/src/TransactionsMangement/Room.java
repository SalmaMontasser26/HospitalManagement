/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransactionsMangement;

import DataManagement.Admin;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salma
 */
public class Room implements Serializable{
    private String roomNumber;
    private String roomType;
    public boolean available = true;
    private Appointment assignedAppointment;

    public Room(String roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public Appointment getAssignedAppointment() {
        return assignedAppointment;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setAssignedAppointment(Appointment assignedAppointment) {
        this.assignedAppointment = assignedAppointment;
    }
    
    public String bookRoom(Appointment appointment) {
            this.setAssignedAppointment(appointment);
            this.available = false;
            String result = "Room ID: "+ this.getRoomNumber() +" booked for Appointment ID: "+ appointment.getAppointmentID();
            return result ;
    }
    
    public static Room getRoomById(String roomNo) {
        List<Room> existingRooms = (List<Room>) Admin.loadItems("rooms.dat", Room.class);
            for (Room room : existingRooms) {
                if (room.getRoomNumber() .equals(roomNo)) {
                    return room;
                }
            }
        System.out.println("Room Not Find");
        return null;
    }
    
    public static List<String> readRoomIdsFromFile(String filePath) {
      List<String> ids = new ArrayList<>();

      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
          List<Room> rooms = (List<Room>) ois.readObject();

          for (Room room : rooms) {
              ids.add(room.getRoomNumber());
          }
      } catch (IOException | ClassNotFoundException e) {
          ids.add("empty");
      }

      return ids;
    } 

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", assignedAppointment=" + assignedAppointment +
                '}';
    }
}

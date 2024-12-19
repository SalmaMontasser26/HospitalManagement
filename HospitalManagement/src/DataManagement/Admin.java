/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salma
 */
public class Admin extends Person implements Serializable{    
    private static final long serialVersionUID = 116085494146443447L;


    public Admin(String ID, String name, String phone, String email, String password) {
        super(ID, name, phone, email, password);
    }
    
    public static <UserType> void storeInFile(String filePath, UserType user) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
 
            @SuppressWarnings("unchecked")
            List<UserType> existingUser = (List<UserType>) ois.readObject();

            existingUser.add(user);

            // Write the updated list back to the file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                oos.writeObject(existingUser);
                System.out.println("Stored successfully: " + user.toString());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error storing: " + user);
            }
        } catch (IOException | ClassNotFoundException e) {
//             If the file doesn't exist, create a new file and store the feedback
            List<UserType> existingUsers = new ArrayList<>();
            existingUsers.add(user);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                oos.writeObject(existingUsers);
                System.out.println("User stored successfully: " + user);
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Error storing: " + user);
            }
        }
    }    
    
public static <UserType extends Person> List<UserType> loadPersons(String filename, Class<UserType> personClass) {
        List<UserType> persons = new ArrayList<>();
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();

            if (obj instanceof List) {
                List<?> list = (List<?>) obj;
                for (Object item : list) {
                    if (personClass.isInstance(item)) {
                        persons.add(personClass.cast(item));
                    }
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return persons;
    }

public static <UserType> List<UserType> loadItems(String filename, Class<UserType> itemClass) {
        List<UserType> items = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();

            if (obj instanceof List) {
                List<?> list = (List<?>) obj;
                for (Object item : list) {
                    if (itemClass.isInstance(item)) {
                        items.add(itemClass.cast(item));
                    }
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return items;
    } 
   
   public static List<String> readIdsFromFile(String filePath) {
        List<String> ids = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            List<? extends Person> persons = (List<? extends Person>) ois.readObject();

            for (Person person : persons) {
                ids.add(person.getID());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ids;
    }
    
    @Override
    public String toString() {
        return "Admin{" +
                "AdminID='" + this.getID() + '\'' +
                ", Admin Name=" + this.getName() +
                ", Admin Email=" + this.getEmail() +
                ", Admin Password=" + this.getPassword() +
                '}';
    }
}


//   public static <UserType> List<UserType> loadAll(String filePath, UserType user) {
//        List<UserType> userList = new ArrayList<>();
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
//            @SuppressWarnings("unchecked")
//            List<UserType> existingUsers = (List<UserType>) ois.readObject();
//            userList.addAll(existingUsers);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("Error loading all data");
//        }
//        return userList;
//    }
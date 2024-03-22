package org.example.Task7;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserializeUser {
    public static void main(String[] args) {
        List<User> userList;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.bin"))){
            userList = (List<User>) ois.readObject();
            for(User user : userList){
                System.out.println(user);
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

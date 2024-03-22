package org.example.Task7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeUser {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Emma", "Walker", 45));
        users.add(new User("Johny", "McFlurry", 29));

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.bin"))){
            oos.writeObject(users);
        } catch (IOException ignored){}

    }
}

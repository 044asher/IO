package org.example.Task7;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String lastname;
    private int age;

    public User(String name, String lastname, int age){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name = " + name +
                ", surname = " + lastname +
                ", age = " + age +
                '}';
    }
    public String getName(){
        return name;
    }
    public String getLastname(){
        return lastname;
    }
    public int getAge(){
        return age;
    }
}

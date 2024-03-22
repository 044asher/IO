package org.example;

import java.io.File;
import java.util.Objects;

public class Task6 {
    public static void main(String[] args) {


        String directoryPath = "C:\\Games and Programms\\Java Programms\\IO\\DirectoryForTask6";
        String extension = ".ioc";

        File directory = new File(directoryPath);
        listFiles(directory, extension);
    }
    public static void listFiles(File file, String extension){
        if(file.isDirectory()){
            for(File f : file.listFiles()){
                listFiles(f, extension);
            }
        }
        else if(file.getName().endsWith(extension)){
            System.out.println(file.getName());
        }
    }
}

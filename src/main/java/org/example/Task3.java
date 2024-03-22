package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("names.txt"))) {
            String names = reader.readLine();

            List<String> nameList = Arrays.asList(names.split(" "));

            System.out.println(nameList);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении из файла: " + e.getMessage());
        }
    }
}

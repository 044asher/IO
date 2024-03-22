package org.example;

import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите список имен, разделенных пробелом:");
        String input = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter("names.txt")) {
            writer.println(input);
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}

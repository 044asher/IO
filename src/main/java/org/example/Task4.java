package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task4 {
    public static void main(String[] args) {
        String sourceFile = "names.txt";
        String targetFile = "newNamesFile.txt";

        try {

            Files.copy(Paths.get(sourceFile), Paths.get(targetFile));

            String originalContent = new String(Files.readAllBytes(Paths.get(sourceFile)));
            String copiedContent = new String(Files.readAllBytes(Paths.get(targetFile)));

            if (originalContent.equals(copiedContent)) {
                System.out.println("Содержимое файла успешно скопировано и проверено.");
            } else {
                System.out.println("Ошибка: содержимое файла не соответствует оригиналу.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при копировании или чтении файла: " + e.getMessage());
        }
    }
}


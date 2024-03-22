package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String directoryName = "uploaded/docs";
        System.out.print("Введите количество файлов для создания: ");
        int numFiles = scanner.nextInt();
        scanner.nextLine();



        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdirs();
        }


        // Создание файлов и заполнение
        List<String> fileNames = new ArrayList<>();
        for (int i = 0; i < numFiles; i++) {
            System.out.print("Введите наименование файла " + (i + 1) + ": ");
            String tempFileName = scanner.nextLine();
            String fileName = generateUniqueFileName(tempFileName);
            fileNames.add(fileName);

            try (PrintWriter writer = new PrintWriter(directoryName + File.separator + fileName)) {
                System.out.print("Введите текст для файла " + fileName + ": ");
                String text = scanner.nextLine();
                writer.println(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Поиск
        System.out.print("Введите слово для поиска в файлах: ");
        String keyword = scanner.nextLine();
        System.out.println("Файлы, содержащие слово '" + keyword + "':");
        for (String fileName : fileNames) {
            try (Stream<String> lines = Files.lines(Paths.get(directoryName, fileName))) {
                if (lines.anyMatch(line -> line.contains(keyword))) {
                    System.out.println(fileName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String generateUniqueFileName(String input) {
        UUID uuid = UUID.randomUUID();
        return uuid + "_" + input;
    }
}

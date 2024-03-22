package org.example;

import java.io.File;


    public class Task5 {
        public static void main(String[] args) {
            String directoryPath = "C:\\Games and Programms\\Java Programms\\IO\\uploaded";

            File directory = new File(directoryPath);

            deleteFiles(directory);
        }

        public static void deleteFiles(File file) {
            File[] files = file.listFiles();

            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        // рекурсивно удаляем если поддиректория
                        deleteFiles(f);
                    }
                    // Само удалеие файла
                    if (f.delete()) {
                        System.out.println("Файл " + f.getName() + " был успешно удален.");
                    } else {
                        System.out.println("Не удалось удалить файл " + f.getName() + ".");
                    }
                }
            } else {
                System.err.println("Директория не содержит файлов или не существует.");
            }
        }
    }



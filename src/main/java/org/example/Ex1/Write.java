package org.example.Ex1;

import org.example.Task7.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Write {
    public static void main(String[] args) {
        //Побайтовая запись:
        String text = "Hello world!";
        try (FileOutputStream fos = new FileOutputStream("notes.txt")) {
            byte[] buffer = text.getBytes();

            fos.write(buffer);
            System.out.println("The file has been written");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        // Побайтовая запись массива байтов
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();//По стандарту создается массив на 32 элемента, в параметрах можно задать нужный размер
        String textForOutputStream = "Hello, i'm ArrayByteWriter";
        byte[] buffer = textForOutputStream.getBytes();
        try{
            arrayOutputStream.write(buffer);
        } catch (IOException ignored){}


        System.out.println("Вывод как строка: " + arrayOutputStream);

        byte[] array = arrayOutputStream.toByteArray();
        System.out.print("Вывод посимвольно из массива байтов: ");
        for (byte b : array){
            System.out.print((char) b);
        }
        System.out.println();


        // Передача массива байт в другой поток:
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String packageText = "Deliver me to other Stream";

        byte[] bufferForPackage = packageText.getBytes();
        try{
            baos.write(bufferForPackage);
        }catch (IOException ignored){}

        try(FileOutputStream fos = new FileOutputStream("Package.txt")){
            baos.writeTo(fos); // Метод для передачи массива байт в другой поток
        } catch (IOException ignored){}



        //Запись примитивных типов данных
        User user = new User("Tom", "Hanks", 45);
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("Ex1.bin"))){
            dos.writeUTF(user.getName());
            dos.writeUTF(user.getLastname());
            dos.writeInt(user.getAge());
            System.out.println("File has been successfully written!");
        }catch (IOException e){
            e.printStackTrace();
        }


        //Запись через PrintStream
        String textForPrint = "Hello, i'm print stream";
        try(PrintStream printStream = new PrintStream(new FileOutputStream("printStream.txt"))){
            printStream.println(textForPrint); //Variant 1

            byte[] charBytesForPrint = textForPrint.getBytes();
            printStream.write(charBytesForPrint); //Variant 2
        }catch (IOException e){
            e.printStackTrace();
        }

        //Запись через PrintWriter
        try(PrintWriter printWriter = new PrintWriter(System.out)){
            printWriter.println("Hello, i'm printWriter and its just console out!");
        }

    }
}

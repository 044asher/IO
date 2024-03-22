package org.example.Ex1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Read {
    public static void main(String[] args) {
        // Побайтовое чтение
        try(FileInputStream fis = new FileInputStream("notes.txt")){
            int i;
            while ((i = fis.read()) != -1){
                System.out.print((char) i);
            }
        }catch (IOException ignored){
        }


        // Побайтовое чтение массива байтов
        String text = "Hello, i'm ByteArrayReader";
        byte[] textBytes = text.getBytes();
        try(ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(textBytes, 11, textBytes.length)){
            int j;
            System.out.println();
            while ((j = arrayInputStream.read()) != -1){
                System.out.print((char)j);
            }
        }catch (IOException ignored){
        }
        //Особенность ByteArrayInputStream в том, что для его закрытия не обязателен метод close()


        //Чтение примитивных типов данных
        try(DataInputStream dis = new DataInputStream(new FileInputStream("Ex1.bin"))){
            String name = dis.readUTF();
            String lastName = dis.readUTF();
            int age = dis.readInt();
            System.out.println("\nName: " + name + ", LastName: " + lastName + ", Age: " + age);
        }catch (IOException e){
            e.printStackTrace();
        }


        // Построчное чтение
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("notes.txt"))){
            String line;
            System.out.print("Buffered Reader: ");
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException ignored){
        }

        // Построчное чтение с помощью Scanner
        try(Scanner scanner = new Scanner(new File("notes.txt"))){
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }catch (FileNotFoundException ignored){
        }
    }
}

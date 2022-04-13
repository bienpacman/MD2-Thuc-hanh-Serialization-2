package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
List<Student> students = new ArrayList<>();
students.add(new Student(1,"Bin","Hà Nam"));
students.add(new Student(2,"Ron","Hà Noi"));
students.add(new Student(3,"Harry","Hà Giang"));
students.add(new Student(4,"Lucy","Hà Nam"));
writeToFile("Student1.txt",students);
List<Student> studentDataFromFile = readDataFromFile("Student1.txt");
        for (Student student:studentDataFromFile) {
            System.out.println(student);
        }
    }

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);

            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois =  new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }
}
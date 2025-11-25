package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        // Create a Java object
        Student s1 = new Student("Alice", 30);
        Student s2 = new Student("Andrew", 22);
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        ObjectMapper mapper = new ObjectMapper();


        try {

            mapper.writeValue(new File("students.json"), studentList);
            System.out.println("Student objects successfully written to students.json");




            File jsonFile = new File("students.json");
            List<Student> students = mapper.readValue(jsonFile, new TypeReference<List<Student>>() {});
            System.out.println(students);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


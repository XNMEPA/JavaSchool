package ru.malychev.jstasks.serialzation;

import ru.malychev.jstasks.serialzation.Serializator.SerialixatorImpl;
import ru.malychev.jstasks.serialzation.Serializator.Serializator;

import java.io.IOException;

/**
 * Created by 7 on 31.01.2020.
 */
public class Serialization {
    public static final String FILENAME = "student";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student(3);
        Serializator serializator = new SerialixatorImpl();
        serializator.serialize(student, FILENAME);
        System.out.println(student.getCourse());
        Student outStudent = (Student) serializator.deserialize(FILENAME);
        System.out.println(outStudent.getCourse());

    }
}

package ru.malychev.jstasks.serialization;

import ru.malychev.jstasks.serialization.serializer.Serializer;
import ru.malychev.jstasks.serialization.serializer.SerializerWithFile;

import java.io.IOException;

/**
 * Created by 7 on 31.01.2020.
 */
public class Serialization {
    public static final String FILENAME = "/home/gendalf/Загрузки/students.obj";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student(3);
        Serializer serializer = new SerializerWithFile();
        serializer.serialize(student, FILENAME);
        System.out.println(student.getCourse());
        Student studentIncarnation = (Student) serializer.deserialize(FILENAME);
        System.out.println(studentIncarnation.getCourse());

    }
}

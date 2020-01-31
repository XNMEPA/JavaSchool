package ru.malychev.jstasks.serialzation.Serializator;

import ru.malychev.jstasks.serialzation.Student;

import java.io.*;

/**
 * Created by 7 on 31.01.2020.
 */
public class SerialixatorImpl implements Serializator {

    @Override
    public void serialize(Object o, String fileName) throws IOException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                ObjectOutputStream out  = new ObjectOutputStream(fileOutputStream)
            ) {
            out.writeObject(o);
        }
    }

    @Override
    public Student deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (
                FileInputStream fileInputStream = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(fileInputStream)
        ) {
            return (Student) in.readObject();
        }
    }
}

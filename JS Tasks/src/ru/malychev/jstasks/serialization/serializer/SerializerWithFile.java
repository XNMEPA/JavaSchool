package ru.malychev.jstasks.serialization.serializer;

import java.io.*;


/**
 * Created by 7 on 31.01.2020.
 */
public class SerializerWithFile implements Serializer {

    @Override
    public void serialize(Object o, String fileName) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream outFile  = new ObjectOutputStream(fileOutputStream))
        {
            outFile.writeObject(o);
        }
    }

    @Override
    public Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream inFile = new ObjectInputStream(fileInputStream))
        {
            return inFile.readObject();
        }
    }
}

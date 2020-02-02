package ru.malychev.jstasks.serialization.serializer;

import java.io.*;


/**
 * Created by 7 on 31.01.2020.
 */
public class SerializerWithFile implements Serializer {

    @Override
    public void serialize(Object o, String fileName) throws IOException {
        ObjectOutputStream outFile  = new ObjectOutputStream(new FileOutputStream(fileName));

        outFile.writeObject(o);

    }

    @Override
    public Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(fileName));

        return inFile.readObject();

    }
}

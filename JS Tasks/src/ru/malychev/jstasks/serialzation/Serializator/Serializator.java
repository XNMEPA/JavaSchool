package ru.malychev.jstasks.serialzation.Serializator;

import jdk.nashorn.internal.codegen.ObjectClassGenerator;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by 7 on 31.01.2020.
 */
public interface Serializator {
    /**
     *
      * @param o
     * @param fileName
     */
    void serialize(Object o, String fileName) throws IOException;

    /**
     *
      * @param fileName
     * @return
     */
    Object deserialize(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException;
}

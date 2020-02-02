package ru.malychev.jstasks.serialization.serializer;

import java.io.IOException;


/**
 * Created by 7 on 31.01.2020.
 * {@link Serializer} Интерфейс сериализатора
 */

public interface Serializer {

    /**
     *
     * @param o Объект сериализации для записи в поток
     * @param outputStream Входной поток сериализуемых объектов
     */
    void serialize(Object o, String outputStream) throws IOException;

    /**
     *
     * @param inputStream Исходящий поток сериализированных объектов
     * @return Прочитанный сериализованный объект
     */
    Object deserialize(String inputStream) throws IOException, ClassNotFoundException;
}

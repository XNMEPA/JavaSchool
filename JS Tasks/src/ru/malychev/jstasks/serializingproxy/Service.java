package ru.malychev.jstasks.serializingproxy;

import java.io.FileNotFoundException;
import java.util.List;

/**
 *  Created by "XNMEPA" on 01.02.2020.
 *  Сервисный интерфейс для сервиса Исполнения Желаний {@link Service}
 */

public interface Service {
    /**
     *
     * @param arguments произвольное количество суммируемых чисел
     * @return сумма всех аргументов
     */
    @Cache(cache = false)
    <T extends Number> double simpleSum(T ... arguments );

    /**
     *
     * @param  result Объект класса Result, для которого необходимо произвести вычисления
     * @return  Result объект с результатами вычислений
     */
    @Cache(cacheType = CacheType.FILE, identityBy = {String.class, double.class})
    Result calc(Result result) throws NoSuchMethodException;

    /**
     *
     * @param nameTxtFile имя загружаемого текстового файла.
     * @return список строк загружаемого файла
     */
    @Cache()
    List<String> txtFileLoader(String nameTxtFile) throws FileNotFoundException;

    /**
     *
     * @param numString номер запрашиваемой строки загруженного файла
     * @param list      ссылка на список, в который были загружены строки файла
     * @return запрошенная строка
     */
    @Cache(cache = false, identityBy = {long.class})
    String getString(int numString, List<String> list);

}

package ru.malychev.jstasks.serializingproxy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *  Created by "XNMEPA" on 01.02.2020.
 *  Сервисный класс Исполнений Желаний {@link WishService}
 */

public class WishService implements Service {
    /**
     * @param arguments произвольное количество суммируемых чисел
     * @return сумма всех аргументов
     */
    @Override
    public <T extends Number> double simpleSum(T ... arguments ) {
        double result = 0.0;
        for (T argument : arguments) {
            if (argument instanceof Long) result +=  argument.longValue();
            else if (argument instanceof Float) result +=  argument.floatValue();
            else if (argument instanceof Double) result +=  argument.doubleValue();
            else result += argument.intValue();
        }
        return result;
    }

    /**
     *
     * @param  result Объект класса Result, для которого необходимо произвести вычисления
     * @return  Result объект с результатами вычислений
     */
    @Override
    public Result calc(Result result) throws NoSuchMethodException {
        double volume;
        switch (result.getNameFunction()) {
            case "sqrt":
                volume = Math.sqrt(result.getArgument());
                break;
            case "sin":
                volume = Math.sin(result.getArgument());
                break;
            case "cos":
                volume = Math.cos(result.getArgument());
                break;
            default:
                throw new NoSuchMethodException("Указанный метод не расчитывается.");
        }
        return result.initialize(volume, new Date().getTime());
    }

    /**
     * @param nameTxtFile имя загружаемого текстового файла.
     * @return список строк загружаемого файла
     */
    @Override
    public List<String> txtFileLoader(String nameTxtFile) {
        List<String> list = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nameTxtFile))) {
            String str;
            while ((str = reader.readLine()) != null) list.add(str);
            return list;
        } catch (IOException e) {
            System.out.println("Непредвиденная ошибка системы ввода/вывода.\nВероятно загружаемый файл не обнаружен.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param numString номер запрашиваемой строки загруженного файла
     * @param list      ссылка на список, в который были загружены строки файла
     * @return запрошенная строка
     */
    @Override
    public String getString(int numString, List<String> list) {
        return list.get(numString);
    }
}

package ru.malychev.jstasks.serializingproxy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  Created by "XNMEPA" on 02.02.2020.
 *  Сервисный класс исполнения желаний {@link Storage}
 */

public class Storage {

    private List<Result> list;
    String fileName = "";

    public Storage() throws FileNotFoundException, ClassNotFoundException {
        this.list = new ArrayList<>();
        try {
            if (Service.class.getMethod("calc", Result.class).getDeclaredAnnotation(Cache.class).cacheType() == CacheType.FILE) {
                this.fileName = Service.class.getMethod("calc", Result.class).getDeclaredAnnotation(Cache.class).fileName();
                Result result;
                try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(this.fileName))) {
                    while ((result = (Result) reader.readObject()) != null) this.list.add(result);
                } catch (FileNotFoundException e) {
                    System.out.println("Ресурс с кешированными данными еще не был создан.\nОн будет создан в процессе работы программы.");
                    throw e;
                } catch (ClassNotFoundException e) {
                    System.err.println("Кеш-файл " + this.fileName + " разрушен и будет удален.");
                    if (new File(this.fileName).delete()) System.out.println(this.fileName + " удален.");
                    else
                        System.out.println(this.fileName + " удалить не удалось.\nЕго удаление необходимо произвести в ручную.");
                    throw e;
                } catch (IOException e) {
                    System.err.println("Неожиданная ошибка системы ввода/вывода!");
                    e.printStackTrace();
                }
            }
        } catch (NoSuchMethodException e) {
            System.err.println("Ошибка аннотирования метода \"calc\".\nМетод пропал из сервиса Исполнения Желаний.");
        }
    }

    public void push(Result result) {
        this.list.add(result);
        try {
            if (Service.class.getMethod("calc", Result.class).getDeclaredAnnotation(Cache.class).cacheType() == CacheType.FILE) {
                try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
                    writer.writeObject(result);
                } catch (FileNotFoundException e) {
                    System.err.println("Непредвиденная ошибка.\nУтерян кеш-файл - " + this.fileName);
                } catch (IOException e) {
                    System.err.println("Неожиданная ошибка системы ввода/вывода!");
                    e.printStackTrace();
                }
            }
        } catch (NoSuchMethodException e) {
            System.err.println("Ошибка аннотирования метода \"calc\".\nМетод пропал из сервиса Исполнения Желаний.");
        }
    }

    public Result get(Result res) {
        for (Result result: this.list) {
            if (result.equals(res)) return result;
        }
        return null;
    }

}

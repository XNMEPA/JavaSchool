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
    private File cacheFile = null;

    public Storage() {
        this.list = new ArrayList<>();
    }

    public Storage(File cacheFile) {
        this();
        this.cacheFile = cacheFile;
        Result result;
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(cacheFile))) {
            list = (List<Result>) reader.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Ресурс для кеширования данных еще не был создан.");
            try {
                if (cacheFile.createNewFile()) System.out.println("Создан кеш-файл: " + cacheFile.getName() + "\n");
                else System.out.println("Кеш-файл " + cacheFile.getName() + " создать не удалось.");
            } catch (IOException ex) {
                System.err.println("Неожиданная ошибка системы ввода/вывода!");
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Кеш-файл " + cacheFile.getName() + " разрушен и будет удален.");
            if (cacheFile.delete()) System.out.println(cacheFile.getName() + " удален.");
            else {
                System.out.println(cacheFile.getName() + " удалить не удалось.\nЕго удаление необходимо произвести в ручную.");
                return;
            }
            try {
                if (cacheFile.createNewFile()) System.out.println("Создан кеш-файл: " + cacheFile.getName());
                else System.out.println("Кеш-файл " + cacheFile.getName() + " создать не удалось.");
            } catch (IOException ex) {
                System.err.println("Неожиданная ошибка системы ввода/вывода!");
                ex.printStackTrace();
            }
        } catch (IOException e) {
            System.err.println("Неожиданная ошибка системы ввода/вывода!");
            e.printStackTrace();
        }
    }

    public void push(Result result) {
        this.list.add(result);
    }

    public Result get(Result res) {
        for (Result result: this.list) {
            if (result.equals(res)) return result;
        }
        return null;
    }

    public boolean safeSave() {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(cacheFile))) {
            writer.writeObject(this.list);
            return true;
        } catch (IOException e) {
            System.err.println("Неожиданная ошибка системы ввода/вывода!");
            e.printStackTrace();
        }
        return false;
    }
}

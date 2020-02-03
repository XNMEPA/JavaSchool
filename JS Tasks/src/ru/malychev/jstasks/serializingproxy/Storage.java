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
            while ((result = (Result) reader.readObject()) != null) this.list.add(result);
        } catch (FileNotFoundException e) {
            System.out.println("Ресурс с кешированными данными еще не был создан.");
            try {
                if (cacheFile.createNewFile()) System.out.println("Создан кеш-файл: " + cacheFile.getName());
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
        if (cacheFile != null)
            try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(cacheFile))) {
                writer.writeObject(result);
            } catch (FileNotFoundException e) {
                System.err.println("Непредвиденная ошибка.\nУтерян кеш-файл - " + cacheFile.getName());
            } catch (IOException e) {
                System.err.println("Неожиданная ошибка системы ввода/вывода!");
                e.printStackTrace();
            }
    }

    public Result get(Result res) {
        for (Result result: this.list) {
            if (result.equals(res)) return result;
        }
        return null;
    }

}

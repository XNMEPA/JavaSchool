package ru.malychev.jstasks.reflection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reflect {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите полное имя класса, включая наименование его пакета: ");
        try {
            String className = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

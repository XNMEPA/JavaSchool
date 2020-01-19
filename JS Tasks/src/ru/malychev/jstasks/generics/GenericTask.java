package ru.malychev.jstasks.generics;

import java.util.HashMap;
import java.util.Map;

public class GenericTask {
    public static void main(String[] args) {
        //Значения для загрузки
        int[] faceValue = {1, 2, 5, 10, 50, 100, 200, 500, 1000, 2000, 5000};
        int[] coins = {1, 2, 100, 2, 5, 1, 200, 1, 10, 500, 10, 100, 10, 5, 1000, 50, 5};
        int[] pocket = {2, 5, 10, 10, 50, 100, 2000, 1, 1, 1, 2, 500};
        String[] apples = {"Голд", "Симеринка", "Антоновка", "Голд", "Голд",
                          "Антоновка", "Антоновка", "Дичка"};

        CountContainer<Integer> wallet = new CountContainer<>();
        for (int i : coins) {
            System.out.println("Кладем в кошелек монету номиналом в " + i + " руб.");
            wallet.add(i);
        }
        System.out.println("Сколько разных монет положили в кошелек? - " + wallet.size() + " шт.\n");

        for (int i : faceValue)
            System.out.println("Сколько монет номиналом в " + i + " руб.? - " + wallet.getCount(i) + " шт.");

        System.out.println("\nВозьмем из кошелька монету номиналом 5 руб.");
        wallet.remove(5);
        System.out.println("Сколько теперь монет номиналом в 5 руб.? " + wallet.getCount(5) + " - шт.");

        CountContainer<Integer> moneyBox = new CountContainer<>();
        System.out.println("\nПереложим содержимое кармана в копилку.");
        for (int i : pocket) {
            System.out.println("Кладем в копилку номинал в " + i + " руб.");
            moneyBox.add(i);
        }

        System.out.println("\nПереложим содержимое копилки в кошелек");
        wallet.addAll(moneyBox);
        System.out.println("Что теперь там лежит в кошельке?");
        for (int i : faceValue)
            System.out.println("Сколько монет номиналом в " + i + " руб.? - " + wallet.getCount(i) + " шт.");
        System.out.println("Сколько стало разных монет? - " + wallet.size() + " - шт.");
        System.out.println("\nА в копилке?");
        moneyBox.clear();
        for (int i : faceValue)
            System.out.println("Сколько монет номиналом в " + i + " руб.? - " + moneyBox.getCount(i) + " шт.");
        System.out.println("\nТеперь переложим всё в портмоне");
        Map<Integer, Integer> purse = new HashMap<>();
        wallet.toMap(purse);
        System.out.println("Что лежит в пормоне?");
        for (Map.Entry<Integer, Integer> pair : purse.entrySet())
            System.out.println("Монет номиналом " + pair.getKey() + " руб. имеем " + pair.getValue() + " шт.");
    }
}

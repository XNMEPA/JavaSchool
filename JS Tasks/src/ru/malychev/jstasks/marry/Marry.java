package ru.malychev.jstasks.marry;

public class Marry {
    public static void main(String[] args) {
        final boolean MAN = true;
        final boolean WOMAN = false;

        Person vasiliy = new Person(MAN, "Василий");
        Person vasilisa = new Person (WOMAN, "Василиса");
        Person petr = new Person(MAN, "Пётр");
        Person alena = new Person (WOMAN, "Алёна");
        Person zakhar = new Person (MAN, "Захар");
        Person zakharia = new Person (WOMAN, "Захария");
        Person viktor = new Person (MAN, "Виктор");
        Person viktoria = new Person (WOMAN, "Виктория");

// Василия женим на Петре.
        System.out.println("\n======================================================================");
        vasiliy.marry(petr);

// Алёну выдаем замуж за Викторию.
        System.out.println("\n======================================================================");
        alena.marry(viktoria);

// Василий хочет жениться на себе.
        System.out.println("\n======================================================================");
        vasiliy.marry(vasiliy);

// Василия женим на Василисе.
        System.out.println("\n======================================================================");
        vasiliy.marry(vasilisa);
// Василия еще раз женим на Василисе.
        System.out.println("\n======================================================================");
        vasiliy.marry(vasilisa);

// Петра женим на Алёне.
        System.out.println("\n======================================================================");
        petr.marry(alena);

// Захара женим на Захарии.
        System.out.println("\n======================================================================");
        zakhar.marry(zakharia);

// Викторию выдаем замуж за Виктора.
        System.out.println("\n======================================================================");
        viktoria.marry(viktor);

// Василия женим на Виктории.
        System.out.println("\n======================================================================");
        vasiliy.marry(viktoria);

// Алена выходит замуж за Виктора.
        System.out.println("\n======================================================================");
        alena.marry(viktor);
    }
}

package ru.malychev.jstask.marry;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse = null;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
        System.out.println((man ? "Создан мужчина - " : "Создана женщина - ") + this.name + ".");
    }

    public boolean getMan() {
        return man;
    }

    public String getName() {
        return name;
    }


    public void setSpouse(Person person) {
        spouse = person;
        if (person != null)
            System.out.println(name + (man ? " женился на " : " вышла замуж за ") + person.getName() + ".");
    }

    public Person getSpouse() {
            return spouse;
    }

    public boolean marry(Person person) {
        System.out.println(name + " и " + person.getName() + " должны пожениться.");
        if (this == person) {
            System.out.println("Оригинально конечно! Но так не получится!");
            return false;
        } else if (this.man == person.getMan()) {
            System.out.println("Мы не приветствуем однополые браки!");
            return false;
        } else if (this == person.getSpouse()) {
            System.out.println("Они же уже женаты!");
            return false;
        } else {
            this.divorce();
            person.divorce();
            this.setSpouse(person);
            person.setSpouse(this);
            System.out.println(name + " и " + person.getName() + " со счастливым вас браком!");
            return true;
        }
    }

    public boolean divorce() {
        if (spouse == null) {
            System.out.println(name + (man ? " холост, не надо разводить." : " одинока, не надо разводить."));
            return false;

        } else {
            System.out.println(name + " и " + spouse.getName() + " должны разойтись.");
            System.out.println(name + (man ? " разведен." : " разведена.") + " Счастливого пути!");
            System.out.println(spouse.getName() + (spouse.getMan() ? " разведен." : " разведена.") + " Счастливого пути!");
            spouse.setSpouse(null);
            spouse = null;

            return true;
        }
    }
}

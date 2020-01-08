package ru.malychev.jstasks;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse = null;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean getMan() {
        return man;
    }

    public void setSpouse(Person person) {
        spouse = person;
    }

    public Person getSpouse() {
        return spouse;
    }

    public boolean marry(Person person) {
        if (this.man == person.getMan() || this == person.spouse) return false;
        else {
            this.divorce();
            this.spouse.divorce();
            person.divorce();
            person.spouse.divorce();
            this.setSpouse(person);
            person.setSpouse(this);
            return true;
        }
    }

    public boolean divorce() {
        if (spouse == null) return false;
        else {
            spouse = null;
            return true;
        }
    }
}

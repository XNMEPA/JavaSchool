package ru.malychev.jstasks.serialzation;

import java.io.Serializable;

/**
 * Created by 7 on 31.01.2020.
 */
public class Student extends Human implements Serializable {
    private int course;

    public Student(int course) {
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}

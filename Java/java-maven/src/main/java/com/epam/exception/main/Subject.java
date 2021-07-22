package com.epam.exception.main;

import com.epam.exception.main.models.Subjects;

public class Subject {
    private final Subjects name;
    private int score;

    public Subject(Subjects name) {
        this.name = name;
    }

    public Subjects getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Subject{" + name +
                '}';
    }
}

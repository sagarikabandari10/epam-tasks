package com.epam.exception.main;

public class Subject {
    private final Common.SUBJECTS name;
    private final int grade;

    public Subject(Common.SUBJECTS name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public Common.SUBJECTS getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }


}

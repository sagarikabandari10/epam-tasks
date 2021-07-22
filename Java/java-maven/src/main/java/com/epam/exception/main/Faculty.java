package com.epam.exception.main;

import com.epam.exception.main.models.Subjects;

import java.time.LocalDate;

public class Faculty extends Person {
    private final String title;
    private final Subjects subjects;

    public Faculty(String name, LocalDate dob, String address, long phone, String title, Subjects subjects) {
        super(name, dob, address, phone);
        this.title = title;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "\nFaculty{" +
                super.toString() +
                ", title='" + title + '\'' +
                ", group=" + subjects +
                '}';
    }
}

package com.epam.exception.main;

import java.time.LocalDate;

public class Teacher extends Person {
    private final String title;
    private final Common.GROUP group;

    public Teacher(String name, LocalDate dob, String address, long phone, String title, Common.GROUP group) {
        super(name, dob, address, phone);
        this.title = title;
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public Common.GROUP getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "\nTeacher{" +
                 super.toString() +
                ", title='" + title + '\'' +
                ", group=" + group +
                '}';
    }
}

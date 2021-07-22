package com.epam.exception.main;

import java.time.LocalDate;

public class Student extends Person {
    private final Group group;

    public Student(String name, LocalDate dob, String address, long phone, Group group) {
        super(name, dob, address, phone);
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "\nStudent{" + super.toString() +
                ",  group=" + group +
                '}';
    }
}

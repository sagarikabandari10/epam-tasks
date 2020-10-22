package com.epam.exception.main;

import java.time.LocalDate;

public class Student extends Person {

    private final Common.SUBJECTS subject;
    private final int grade;

    public Student(String name, LocalDate dob, String address, long phone, Common.SUBJECTS subject, int grade) {
        super(name, dob, address, phone);
        this.subject = subject;
        this.grade = grade;
    }


    public Common.SUBJECTS getSubject() {
        return subject;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                ", " + super.toString() +
                ", group=" + subject +
                ", grade=" + grade +
                '}';
    }
}

package com.epam.classes;

import java.time.LocalDate;

public abstract class Person implements Comparable<Object> {
    private final int id;
    private final String surname;
    private final String name;
    private final String patronymic;
    private final LocalDate dob;
    private final String address;
    private final long phone;

    public Person(int id, String surname, String name, String patronymic, LocalDate dob, String address,
                  long phone) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
    }

    protected String getName() {
        return name;
    }

    protected LocalDate getDob() {
        return dob;
    }

    protected int get_Year() {
        return dob.getYear();
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", ";
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Person) o).name);
    }
}

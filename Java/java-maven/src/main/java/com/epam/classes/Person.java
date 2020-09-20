package com.epam.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person implements Comparable<Object> {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dob;
    private String address;
    private long phone;

    public Person() {

    }
    public Person(int id, String surname, String name, String patronymic, String dob, String address,
                  long phone) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dob = LocalDate.parse(
                dob,
                DateTimeFormatter.ofPattern( "dd/MM/yyyy" )
        );
        this.address = address;
        this.phone = phone;
    }
    protected int getId() {
        return id;
    }
    protected String getSurname() {
        return surname;
    }
    protected String getName() {
        return name;
    }
    protected String getPatronymic() {
        return patronymic;
    }
    protected LocalDate getDob() {
        return dob;
    }
    protected int  get_Year() {
        return dob.getYear();
    }
    protected String getAddress() {
        return address;
    }
    protected long getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return " [id=" + id + ", Surname=" + surname + ", Name=" + name + ", Patronymic=" + patronymic
                + ", DOB=" + dob + ", Address=" + address + ", Phone=" + phone+",";
    }
    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Person) o).name);
    }
}

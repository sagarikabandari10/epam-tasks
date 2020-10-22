package com.epam.exception.main;

import java.time.LocalDate;

public abstract class Person {
    private final String name;
    private final LocalDate dob;
    private final String address;
    private final long phone;

    public Person(String name, LocalDate dob, String address, long phone) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public long getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", phone=" + phone;
    }
}

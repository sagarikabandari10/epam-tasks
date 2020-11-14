package com.epam.classes;

import java.time.LocalDate;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer extends Person {
    private final long creditCardNumber;
    private final long bankAccountNumber;

    public Customer(int id, String surname, String name, String patronymic, LocalDate dob, String address, long phone,
                    int creditCardNumber, long bankAccountNumber) {
        super(id, surname, name, patronymic, dob, address, phone);
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public static void main(String[] args) {
        List<Customer> customers = getCustomers();
        System.out.println("List of buyers in alphabetical order:");
        Collections.sort(customers);
        customers.forEach(c -> System.out.print(c.getName() + " : " + c + "\n"));

        long minRange = 6_000, maxRange = 2_600_000;
        System.out.printf("\nList of customers whose credit card number in %d - %d range:%n", minRange, maxRange);
        for (Customer customer : customers) {
            if (ValueRange.of(minRange, maxRange).isValidIntValue(customer.creditCardNumber)) {
                System.out.println("CreditCard-" + customer.creditCardNumber + " : " + customer);
            }
        }
    }

    private static List<Customer> getCustomers() {
        List<Customer> list = new ArrayList<>();
        list.add(new Customer(0, "Padakanti", "Ravi",
                " Luc ", LocalDate.of(1986, 7, 29), "Minsk", 988225, 6969, 5615));
        list.add(new Customer(3, "Padakanti", "Prateek kumar",
                " Lack ", LocalDate.of(2015, 5, 28), "Minsk", 258225, 8789654, 789258));
        list.add(new Customer(1, "Kumudi", "Anil ",
                " Kumar ", LocalDate.of(1989, 1, 10), "Minsk", 988985, 5893, 45879635));
        list.add(new Customer(2, "Bandari", "Kiran",
                " Mack ", LocalDate.of(2001, 8, 14), "Hyderabad", 966225, 2547185, 321654));
        return list;
    }

    @Override
    public String toString() {
        return super.toString() + " creditCardNumber=" + creditCardNumber + ", bankAccountNumber=" + bankAccountNumber + "]";
    }
}


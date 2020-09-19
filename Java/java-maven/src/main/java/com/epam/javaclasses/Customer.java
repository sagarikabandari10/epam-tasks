package com.epam.javaclasses;

import java.time.temporal.ValueRange;
import java.util.*;

public class Customer extends Person
{
    private int creditCardNumber;
    private long bankAccountNumber;

    public Customer(int _id, String _Surname, String _Name, String _Patronymic, String _DOB, String _Address, long _Phone,
                    int creditCardNumber, long bankAccountNumber) {
        super(_id, _Surname, _Name, _Patronymic, _DOB, _Address, _Phone);
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    protected int getCreditCardNumber() {
        return creditCardNumber;
    }

    protected long getBankAccountNumber() {
        return bankAccountNumber;
    }

    private static List<Customer> getCustomers(){
        List<Customer> list = new ArrayList<>();
        list.add(new Customer(0,"Padakanti","Ravi kumar",
                "  " ,"29/07/1986","Minsk",988225,6969,5615));
        list.add(new Customer(3,"Padakanti","Prateek kumar",
                "  " ,"29/07/1989","Minsk",258225,8789654,789258 ));
        list.add(new Customer(1,"K","Anil ",
                " Kumar " ,"29/07/1988","Minsk",988985,5893,45879635));
        list.add(new Customer(2,"Padakanti","Sagarika",
                "  " ,"29/07/1989","Hyderabad",966225,2547185,321654));
        return list;
    }

    @Override
    public String toString() {
        return super.toString()+ " creditCardNumber=" + creditCardNumber + ", bankAccountNumber=" + bankAccountNumber + "]";
    }

    public static void main(String[] args) {
        List<Customer> customers =getCustomers();
        System.out.println("List of buyers in alphabetical order:");
        Collections.sort(customers);
        customers.forEach(c -> System.out.print(c.getName()+" : "+c +"\n"));

        long minRange = 5000, maxRange=2600000;
        System.out.println(String.format("\nList of customers whose credit card number in %d - %d range:", minRange, maxRange));
        for(Customer customer : customers) {
            if(ValueRange.of(minRange, maxRange).isValidIntValue(customer.creditCardNumber)) {
                System.out.println("CreditCard-"+customer.creditCardNumber +" : "+customer);
            }
        }
    }
}


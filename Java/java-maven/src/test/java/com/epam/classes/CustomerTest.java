package com.epam.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void isCreditCardWithInRangeIsValid() {
        long minRange = 5000, maxRange = 80000, creditCardNumber = 60000;
        assertTrue(Customer.isCreditCardWithInRange(minRange, maxRange, creditCardNumber));
    }

    @Test
    void isCreditCardWithInRangeIsInvalid() {
        long minRange = 5000, maxRange = 80000, creditCardNumber = 600;
        assertFalse(Customer.isCreditCardWithInRange(minRange, maxRange, creditCardNumber));
    }

    @Test
    void isCreditCardWithInRangeMaxGreaterThanMinValue() {
        long minRange = 500, maxRange = 80, creditCardNumber = 100;
        assertThrows(IllegalArgumentException.class, () -> Customer.isCreditCardWithInRange(minRange, maxRange, creditCardNumber));
    }

    @Test
    void getCustomers() {
        assertTrue(Customer.getCustomers().size() > 0, "Customer should not be empty.");
    }
}
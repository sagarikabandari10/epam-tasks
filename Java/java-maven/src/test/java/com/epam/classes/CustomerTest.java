package com.epam.classes;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void isCreditCardWithInRangeIsValid() {
        long minRange = 5000, maxRange = 80000, creditCardNumber = 60000;
        Assert.assertTrue(Customer.isCreditCardWithInRange(minRange, maxRange, creditCardNumber));
    }

    @Test
    public void isCreditCardWithInRangeIsInvalid() {
        long minRange = 5000, maxRange = 80000, creditCardNumber = 600;
        Assert.assertFalse(Customer.isCreditCardWithInRange(minRange, maxRange, creditCardNumber));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isCreditCardWithInRangeMaxGreaterThanMinValue() {
        long minRange = 500, maxRange = 80, creditCardNumber = 100;
        Customer.isCreditCardWithInRange(minRange, maxRange, creditCardNumber);
    }

    @Test
    public void getCustomers() {
        Assert.assertTrue(Customer.getCustomers().size() > 0);
    }
}
package com.epam.webdriver.page.pastebin.model;

public enum Expiration {
    NEVER("Never"),
    BURN_AFTER_READ("Burn after read"),
    TEN_MINUTES("10 Minutes"),
    ONE_Hour("1 Hour"),
    ONE_Day("1 Day");

    private String value;
    Expiration(String value) {
        this.value=value;
    }

    public String getValue(){return this.value;}
}

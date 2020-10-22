package com.epam.exception.practice;

import java.io.FileWriter;
import java.io.IOException;

public class GreyStone extends Stone {
    @Override
    public void accept(String data) throws  ResourceException {
        try {
            FileWriter writer = new FileWriter("data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

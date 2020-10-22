package com.epam.exception.practice;

public class ConstructorMain {
    public static void main(String[] args) {
        try{
            ConcreteResource resource = new ConcreteResource();
        }
        catch (ResourceException ex){
            ex.printStackTrace();
        }
        SameResource sameResource = new SameResource();


    }
}

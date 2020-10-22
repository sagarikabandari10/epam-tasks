package com.epam.exception.practice;

public class StoneService {
    public void buildHouse(Stone stone){
        try{
        stone.accept("stones.");
        }
        catch (ResourceException e){
            System.err.print(e);
        }
    }
}

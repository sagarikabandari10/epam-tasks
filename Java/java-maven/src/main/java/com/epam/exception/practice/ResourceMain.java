package com.epam.exception.practice;

public class ResourceMain {
    public static void main(String[] args) {
       Resource resource = new Resource();
       try {
           ResourceAction.load(resource);
       }
       catch(ResourceException e){
           e.printStackTrace();

       }
    }
}

package com.epam.exception.practice;

public class ResourceAction {
    public static void load(Resource resource) throws ResourceException {
        if(resource == null || !resource.exists() || !resource.iscreate()){
           throw new ResourceException("My custom message.");
        }
    }
}

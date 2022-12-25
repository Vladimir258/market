package ru.geekbrains.spring.market.auth.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static ResourceNotFoundException instance;

    public ResourceNotFoundException () {
    }

    public static ResourceNotFoundException getInstance() {
        if(instance == null) {
            instance = new ResourceNotFoundException();
        }
        return instance;
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

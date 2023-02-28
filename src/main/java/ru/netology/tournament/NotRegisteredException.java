package ru.netology.tournament;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Player " + name + " not registered.");
    }
}

package main;

import handler.EmptyFieldValidator;
import handler.ExistingUserValidator;
import handler.ValidUserLoginValidator;
import handler.ValidationHandler;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<User> users = new ArrayList<>();

    public boolean register(String username, String password) {
        ValidationHandler handler = new EmptyFieldValidator();
        handler.setNext(new ExistingUserValidator(users));

        if (!handler.handleRequest(username, password)) {
            return false;
        }

        users.add(new User(username, password));
        System.out.println("Usuário cadastrado com sucesso!");
        return true;
    }

    public boolean login(String username, String password) {
        ValidationHandler handler = new EmptyFieldValidator();
        handler.setNext(new ValidUserLoginValidator(users));

        if (!handler.handleRequest(username, password)) {
            return false;
        }

        System.out.println("Login feito!");
        return true;
    }
}

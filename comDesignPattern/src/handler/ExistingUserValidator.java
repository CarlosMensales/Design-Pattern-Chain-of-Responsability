package handler;

import model.User;

import java.util.List;

public class ExistingUserValidator extends ValidationHandler {
    private List<User> users;

    public ExistingUserValidator(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean handleRequest(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Erro: Usuário já existe.");
                return false;
            }
        }
        if (next != null) {
            return next.handleRequest(username, password);
        }
        return true;
    }
}

package handler;

import model.User;

import java.util.List;

public class ValidUserLoginValidator extends ValidationHandler {
    private List<User> users;

    public ValidUserLoginValidator(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean handleRequest(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        System.out.println("Erro: Usuário ou senha incorretos!");
        return false;
    }
}

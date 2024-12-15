package handler;

public class EmptyFieldValidator extends ValidationHandler {
    @Override
    public boolean handleRequest(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("Erro: Campo vazio!");
            return false;
        }
        if (next != null) {
            return next.handleRequest(username, password);
        }
        return true;
    }
}

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginService {
    private List<User> users = new ArrayList<>();

    public boolean register(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("Erro: Campo vazio!");
            return false;
        }

        for(User user : users){
            if(user.getUsername().equals(username)) {
                System.out.println("Erro: Usuário já existe.");
                return false;
            }
        }
        users.add(new User(username, password));
        System.out.println("Usuário cadastrado com sucesso!");
        return true;
    }

    public boolean login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("Erro: campo vazio!");
            return false;
        }

        for (User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login feito!");
                return true;
            }
        }

        System.out.println("Usuário ou senha incorretos!");
        return false;
    }

    public static void main(String[] args) {
        String menu =
                """
                Escolha uma opção:
                1 - Registrar um usuário
                2 - Realizar login
                3 - Sair
                """;
        LoginService loginService = new LoginService();
        Scanner sc = new Scanner(System.in);
        int choice = 100;
        String username;
        String password;
        do {
            System.out.println(menu);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Digite o username!");
                    username = sc.nextLine();
                    System.out.println("Digite a senha!");
                    password = sc.nextLine();
                    loginService.register(username, password);
                    break;
                case 2:
                    System.out.println("Digite o username!");
                    username = sc.nextLine();
                    System.out.println("Digite a senha!");
                    password = sc.nextLine();
                    loginService.login(username, password);
                    break;
                case 3:
                    System.out.println("Saindo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while(choice != 3);

        sc.close();
    }

}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
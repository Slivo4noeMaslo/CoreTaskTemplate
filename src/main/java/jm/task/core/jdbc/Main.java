package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Alexandr", "Pushkin", (byte) 36);
        userService.saveUser("Sergey", "Esenin", (byte) 30);
        userService.saveUser("Mihail", "Lermontov", (byte) 27);
        userService.saveUser("Lev", "Tolstoy", (byte) 82);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}

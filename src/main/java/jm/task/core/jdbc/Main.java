package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();


        userService.createUsersTable();
        userService.saveUser("Erik", "Papikian", (byte) 24);
        userService.saveUser("Ilia", "Topuria", (byte) 17);
        userService.saveUser("Aleksandr", "Peeps", (byte) 26);
        userService.saveUser("Carl", "Johnson", (byte) 45);


        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}

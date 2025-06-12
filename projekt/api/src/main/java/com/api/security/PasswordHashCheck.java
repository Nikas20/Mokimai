package com.api.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashCheck {
    public static void main(String[] args) {
        String rawPassword = "cust226"; // тот, что ты вводишь при авторизации
        String hashedPasswordFromDB = "$2a$10$Y3fnmkun6qNZkQLfDYgRBe9pbtu98TNS0qXIY/aXxVJ..."; // вставь полный хеш

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Проверка пароля
        boolean matches = encoder.matches(rawPassword, hashedPasswordFromDB);
        System.out.println("Пароль совпадает: " + matches);

        // Генерация нового хеша
        String newHashed = encoder.encode(rawPassword);
        System.out.println("Новый BCrypt-хеш: " + newHashed);
    }
}

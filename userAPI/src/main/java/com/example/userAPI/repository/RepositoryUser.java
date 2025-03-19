package com.example.userAPI.repository;

import org.springframework.stereotype.Repository;
import ru.pavel.lib.User;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class RepositoryUser {
    Map<String, User> listUser;

    public RepositoryUser(Map<String, User> listUser) {
        this.listUser = new ConcurrentHashMap<>();
        User user = new User();
        user.setId("1");
        user.setName("Иванов Пётр Васильевич");
        user.setAddress("г.Москва пер.Кривоколенный д.5");
        user.setEmail("petr@yamdex.ru");
        user.setNumber("89273885544");
        User user2 = new User();
        user2.setId("2");
        user2.setName("Петров Демьян Сидорович");
        user2.setAddress("г.Пенза ул.Ленина д.38 кв.104");
        user2.setEmail("sidr@gmail.com");
        user2.setNumber("89271119933");
        this.listUser.put(user.getId(), user);
        this.listUser.put(user2.getId(), user2);
    }

    public Optional<User> getUser(String userId) {
        return Optional.ofNullable(listUser.get(userId));
    }

    public void addUser(User user) {
        if (!this.listUser.containsKey(user.getId())) {
            listUser.put(user.getId(), user);
        }
    }
}

package com.example.userAPI.controller;


import com.example.userAPI.service.ServiceUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.pavel.lib.User;

@RestController
public class ControllerUser {
    private final ServiceUser serviceUser;

    public ControllerUser(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        return serviceUser.getUser(userId);
    }
}

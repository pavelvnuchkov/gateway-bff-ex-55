package com.example.userAPI.service;

import com.example.userAPI.repository.RepositoryUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.pavel.lib.User;

import java.util.Optional;

@Service
public class ServiceUser {
    private final RepositoryUser repositoryUser;

    public ServiceUser(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public ResponseEntity<User> getUser(String userId) {
        Optional<ru.pavel.lib.User> optionalUser = repositoryUser.getUser(userId);
        if (optionalUser.isPresent()) {
            return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new User(), HttpStatus.BAD_REQUEST);
    }
}

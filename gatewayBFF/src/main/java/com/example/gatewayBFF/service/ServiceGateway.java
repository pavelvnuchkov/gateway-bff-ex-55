package com.example.gatewayBFF.service;

import com.example.gatewayBFF.model.UserOrderDto;
import com.example.gatewayBFF.repository.RepositoryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceGateway {

    private final RepositoryGateway repositoryGateway;

    public ServiceGateway(RepositoryGateway repositoryGateway) {
        this.repositoryGateway = repositoryGateway;
    }

    public ResponseEntity<UserOrderDto> getInfoOrder(String userId) {
        Optional<UserOrderDto> dtoOptional = repositoryGateway.getUserOrder(userId);
        if (dtoOptional.isPresent()) {
            return new ResponseEntity<>(dtoOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(new UserOrderDto(), HttpStatus.BAD_REQUEST);
    }
}

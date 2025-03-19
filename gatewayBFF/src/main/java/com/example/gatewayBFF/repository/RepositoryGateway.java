package com.example.gatewayBFF.repository;

import com.example.gatewayBFF.model.UserOrderDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.pavel.Order;
import ru.pavel.lib.User;

import java.util.Optional;

@Component
public class RepositoryGateway {


    private RestTemplate template;

    @Value("${domain-address-user}")
    private String userURI;

    @Value("${domain-address-order}")
    private String orderUri;

    public RepositoryGateway(RestTemplate template) {
        this.template = new RestTemplate();
    }

    public Optional<UserOrderDto> getUserOrder(String userID) {

        HttpEntity<String> entity = new HttpEntity<>(null);

        Order order;
        try {
            order = template.exchange(orderUri + userID, HttpMethod.GET, entity, Order.class).getBody();

        } catch (HttpClientErrorException e) {
            return Optional.empty();
        }

        User user;
        try {
            user = template.exchange(userURI + userID, HttpMethod.GET, entity, User.class).getBody();
        } catch (HttpClientErrorException e) {
            return Optional.empty();
        }
        return mappingUserOrder(user, order);
    }

    public Optional<UserOrderDto> mappingUserOrder(User user, Order order) {
        if (user == null || order == null) {
            return Optional.empty();
        }
        UserOrderDto userOrderDto = new UserOrderDto();
        userOrderDto.setUser(user);
        userOrderDto.setOrderId(order.getId());
        userOrderDto.setOrderAmount(order.getAmount());
        userOrderDto.setOrderCurrency(order.getCurrency());
        userOrderDto.setProductList(order.getProductList());
        return Optional.ofNullable(userOrderDto);
    }
}

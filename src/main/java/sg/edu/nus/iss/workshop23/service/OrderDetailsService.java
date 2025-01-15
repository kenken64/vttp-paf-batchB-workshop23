package sg.edu.nus.iss.workshop23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.workshop23.models.OrderDetails;
import sg.edu.nus.iss.workshop23.repository.OrderRepository;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderDetails getOrderDetailsWithDiscount(int orderId) {
        return orderRepository.getOrderDetailsWithDiscount(orderId);
    }
}

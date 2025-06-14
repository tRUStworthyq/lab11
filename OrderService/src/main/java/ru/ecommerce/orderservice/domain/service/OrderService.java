package ru.ecommerce.orderservice.domain.service;

import org.springframework.data.domain.Pageable;
import ru.ecommerce.orderservice.application.dto.request.CartItem;
import ru.ecommerce.orderservice.domain.model.Order;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.UUID;

public interface OrderService {
    Order createOrder(UUID userId, List<CartItem> cartItems);
    boolean cancelOrder(UUID id, UUID userId) throws AccessDeniedException;
    List<Order> findOrdersByUserId(UUID userId, Pageable pageable);
    boolean acceptOrder(UUID orderId);
    Order findPendingOrderById(UUID id);
    Order findById(UUID id);
}

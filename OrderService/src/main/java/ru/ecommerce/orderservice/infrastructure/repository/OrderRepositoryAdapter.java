package ru.ecommerce.orderservice.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import ru.ecommerce.orderservice.domain.model.Order;
import ru.ecommerce.orderservice.domain.model.OrderStatus;
import ru.ecommerce.orderservice.domain.repository.OrderRepository;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {
    @Autowired
    private DataMongoRepository repository;
    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public Optional<Order> findByIdAndStatus(UUID id) {
        return repository.findByIdAndStatus(id, OrderStatus.CREATED);
    }

    @Override
    public Page<Order> findByUserId(UUID userId, Pageable pageable) {
        return repository.findByUserIdAndStatus(userId, pageable, OrderStatus.CREATED);
    }

    @Override
    public Optional<Order> findByIdPendingOrders(UUID id) {
        return repository.findByIdAndStatus(id, OrderStatus.PENDING);
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return repository.findById(id);
    }
}

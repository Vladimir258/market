package ru.geekbrains.spring.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.market.entities.Order;

import java.util.Collection;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Collection<Object> findAllById(Long userId);
}

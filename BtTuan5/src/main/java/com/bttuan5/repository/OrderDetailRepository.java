package com.bttuan5.repository;

import com.bttuan5.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findAll();
    Optional<OrderDetail> findById(Long id);
    Object save(OrderDetail orderDetail);
    void remove(Long id);
    List<OrderDetail> findByProduct(Long productId);
    List<OrderDetail> findByOrder(Long orderId);
    List<OrderDetail> findByPrice(double min, double max);
    List<OrderDetail> findByPriceAndProduct(double min, double max, Long productId);
    List<OrderDetail> findByPriceAndOrder(double min, double max, Long orderId);
    List<OrderDetail> findByPriceAndProductAndOrder(double min, double max, Long productId, Long orderId);
}

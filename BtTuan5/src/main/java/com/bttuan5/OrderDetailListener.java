package com.bttuan5;

import com.bttuan5.repository.OrderDetailRepository;
import com.bttuan5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDetailListener {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EmailService emailService;

    public void onOrderDetailCreated(Long orderDetailId) {
        orderDetailRepository.findById(orderDetailId).ifPresent(orderDetail -> {
            if (orderDetail.getQuantity() > orderDetail.getProduct().getStock()) {
                orderDetailRepository.remove(orderDetailId);
                emailService.sendOrderRejection(orderDetail.getOrder().getCustomer().getId());
            } else {
                productRepository.findById(orderDetail.getProduct().getId()).ifPresent(product -> {
                    product.setStock(product.getStock() - orderDetail.getQuantity());
                    productRepository.save(product);
                });
            }
        });
    }

    public void onOrderDetailRemoved(Long orderDetailId) {
        orderDetailRepository.findById(orderDetailId).ifPresent(orderDetail -> {
            productRepository.findById(orderDetail.getProduct().getId()).ifPresent(product -> {
                product.setStock(product.getStock() + orderDetail.getQuantity());
                productRepository.save(product);
            });
        });
    }

    public void onOrderDetailUpdated(Long orderDetailId) {
        orderDetailRepository.findById(orderDetailId).ifPresent(orderDetail -> {
            if (orderDetail.getQuantity() > orderDetail.getProduct().getStock()) {
                orderDetailRepository.remove(orderDetailId);
                emailService.sendOrderRejection(orderDetail.getOrder().getCustomer().getId());
            } else {
                productRepository.findById(orderDetail.getProduct().getId()).ifPresent(product -> {
                    product.setStock(product.getStock() - orderDetail.getQuantity());
                    productRepository.save(product);
                });
            }
        });
    }

    public void onOrderDetailQuantityUpdated(Long orderDetailId, int oldQuantity) {
        orderDetailRepository.findById(orderDetailId).ifPresent(orderDetail -> {
            productRepository.findById(orderDetail.getProduct().getId()).ifPresent(product -> {
                product.setStock(product.getStock() + oldQuantity - orderDetail.getQuantity());
                productRepository.save(product);
            });
        });
    }




}

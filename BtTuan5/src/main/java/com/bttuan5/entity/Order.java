package com.bttuan5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private double total;
    private String status;
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;
    // getter and setter
}

package com.example.week02;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private String paymentMethod;

    @Builder
    public Order(long orderid, User user, LocalDateTime orderDate, int totalPrice, String paymentMethod) {
        this.orderid = orderid;
        this.user = user;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

}

package com.shop24.api.model;


import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Order() {
    }

    public Order(double totalPrice, int number_of_drinks, Client client) {
        this.totalPrice = totalPrice;
        this.number_of_drinks = number_of_drinks;
        this.client = client;
    }

    private OrderStatus status=OrderStatus.PENDING;
    private double totalPrice;
    private int number_of_drinks;
    @ManyToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumber_of_drinks() {
        return number_of_drinks;
    }

    public void setNumber_of_drinks(int number_of_drinks) {
        this.number_of_drinks = number_of_drinks;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}

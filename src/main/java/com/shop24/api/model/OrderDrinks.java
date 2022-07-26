package com.shop24.api.model;

import javax.persistence.*;

@Entity
public class OrderDrinks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private CargoDrink drink;

    public OrderDrinks() {
    }

    public OrderDrinks(Order order, CargoDrink drink) {
        this.order = order;
        this.drink = drink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

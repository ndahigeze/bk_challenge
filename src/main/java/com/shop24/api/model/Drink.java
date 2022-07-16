package com.shop24.api.model;

import javax.persistence.*;

@Entity
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String type;
    private double price;

    private int consumedTimes;

    public int getConsumedTimes() {
        return consumedTimes;
    }

    public void setConsumedTimes(int consumedTimes) {
        this.consumedTimes = consumedTimes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                '}';
    }
}

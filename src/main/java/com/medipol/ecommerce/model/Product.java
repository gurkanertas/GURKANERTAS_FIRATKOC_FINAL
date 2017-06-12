package com.medipol.ecommerce.model;

public class Product {

    private Integer id;
    public String name;
    public Integer price;

    public Product() {
    }

    public Product(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}

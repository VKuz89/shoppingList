package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private BigDecimal discount;
    private String description;
//
    public void setDiscount(BigDecimal discount) {
        BigDecimal firstLimit = new BigDecimal("0");
        BigDecimal secondLimit = new BigDecimal("100");
        if (discount.compareTo(firstLimit) > 0 && discount.compareTo(secondLimit) < 0) {
            this.discount = discount;
            discount.divide(new BigDecimal(100));
            price = price.subtract(price.multiply(discount.divide(new BigDecimal(100))));
        } else {
            System.out.println("Please enter valid discount value!");
        }
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        if (name.length() > 3 && name.length() < 32) {
            this.name = name;
        } else {
            System.out.println("The name length should be  between 3 and 32 symbols!");
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) > 0) {
            this.price = price;
        } else {
            System.out.println("Price should be larger than zero!");
        }
    }


    public void setCategory(int catNumber) {
        Category category = null;
        if (catNumber == 1){
            this.category = category.MILK;
        } else if (catNumber == 2){
            this.category = category.FRUITS;
        } else if (catNumber == 3){
            this.category = category.VEGETABLES;
        } else if (catNumber == 4){
            this.category = category.BREAD;
        } else if (catNumber == 5){
            this.category = category.FISH;
        } else if (catNumber == 0){
            this.category = null;
        }
        }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }
}
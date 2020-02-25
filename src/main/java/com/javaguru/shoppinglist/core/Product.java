package com.javaguru.shoppinglist.core;

import java.math.BigDecimal;
import java.util.Objects;


public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private BigDecimal discount;
    private String description;

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscount() {
        return discount;
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
            this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price=price;
        BigDecimal result;
       if (discount.equals(BigDecimal.ZERO)) {
           this.price = price;
     } else {
        result = price.multiply(discount.divide(new BigDecimal(100)));
        this.price = price.subtract(result);
     }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                category == product.category &&
                Objects.equals(discount, product.discount) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, discount, description);
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

    public Category getCategory() {
        return category;
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
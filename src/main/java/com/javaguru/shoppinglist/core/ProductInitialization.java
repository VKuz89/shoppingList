package com.javaguru.shoppinglist.core;

import com.javaguru.shoppinglist.database.ProductRepositoryImpl;

import java.math.BigDecimal;

public class ProductInitialization {
    ProductRepositoryImpl database = new ProductRepositoryImpl();
    public Product productInit (String productName, BigDecimal productPrice, int categoryNumber, BigDecimal discount, String description){
        Product product = new Product();
        product.setName(productName);
        product.setDiscount(discount);
        product.setPrice(productPrice);
        product.setCategory(categoryNumber);
        product.setDescription(description);
        product.setId(database.getProductIdSequence());
        return product;
    }
}

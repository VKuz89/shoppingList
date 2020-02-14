package com.javaguru.shoppinglist.core;

import java.math.BigDecimal;

public class ProductInitialization {
    public Product productInit (String productName, BigDecimal productPrice, int categoryNumber, BigDecimal discount, String description,
                             Long ID){  // use lower case letters for parameters
        Product product = new Product();
        product.setName(productName);
        product.setDiscount(discount);
        product.setPrice(productPrice);
        product.setCategory(categoryNumber);
        product.setDescription(description);
        product.setId(ID);
        return product;
    }
}

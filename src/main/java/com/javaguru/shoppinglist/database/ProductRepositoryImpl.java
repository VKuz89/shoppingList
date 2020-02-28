package com.javaguru.shoppinglist.database;

import com.javaguru.shoppinglist.core.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    Map<Long, Product> localDatabase = new HashMap<>();
    private Long productIdSequence = 0L;

    @Override
    public void insert(Product product) {
        product.setId(productIdSequence);
        localDatabase.put(productIdSequence, product);
        productIdSequence++;
    }

    @Override
    public Product read(Long productID) {
        return localDatabase.get(productID);
    }

    @Override
    public void print() {
        for (Product product : localDatabase.values()) {
            System.out.println(product);
        }
    }

    @Override
    public void delete(Long productID) {
        localDatabase.remove(productID);
    }

    public Long getProductIdSequence() {
        return productIdSequence;
    }

}

package com.javaguru.shoppinglist.database;

import com.javaguru.shoppinglist.core.Product;

public interface ProductRepository {
    void insert(Product product);

    Product read(Long productID);

    void print();

    void delete(Long productID);
}

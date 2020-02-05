package com.javaguru.shoppinglist.Database;

import com.javaguru.shoppinglist.ProductService.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    Map<Long, Product> localDatabase = new HashMap<>();

    @Override
    public Product insert(Long productID, Product product) {
        localDatabase.put(product.getId(),product);
        return null;
    }
    @Override
    public Product read(Long productID) {
        return localDatabase.get(productID);
    }

    @Override
    public Product print() {
        for (Product product : localDatabase.values()) {
            System.out.println(product);
        }
        return null;
    }

    @Override
    public Product delete(Long productID) {
        localDatabase.remove(productID);
        return null;
    }

}

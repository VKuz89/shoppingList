package com.javaguru.shoppinglist.database;

import com.javaguru.shoppinglist.core.Product;

public interface ProductRepository {
    Product insert (Long productID, Product product);
    Product read (Long productID);
    Product print ();
    Product delete (Long productID);
}

package com.javaguru.shoppinglist.Database;

import com.javaguru.shoppinglist.ProductService.Product;

public interface ProductRepository {
    Product insert (Long productID, Product product);
    Product read (Long productID);
    Product print ();
    Product delete (Long productID);
}

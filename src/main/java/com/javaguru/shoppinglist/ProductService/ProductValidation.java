package com.javaguru.shoppinglist.ProductService;

import java.math.BigDecimal;

public interface ProductValidation {
    boolean isNameValid (String productName);
    boolean isPriceValid (BigDecimal productPrice);
    boolean isDiscountValid (BigDecimal productDiscount);
    boolean isCategoryValid (Integer categoryNumber);

}

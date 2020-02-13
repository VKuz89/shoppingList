package com.javaguru.shoppinglist.ProductService;

import java.math.BigDecimal;

public class ProductValidationImpl implements ProductValidation {

    @Override
    public boolean isNameValid(String productName) {
        boolean isValid = false;
        if (productName.length() >= 3 && productName.length() <= 32) {
            isValid = true;
        } else {
            throw new ProductValidationException("Error! Product name should be between 3 and 32 symbols!");
        }
        return isValid;
    }

    @Override
    public boolean isPriceValid(BigDecimal productPrice) {
        boolean isValid = false;
        if (productPrice.compareTo(BigDecimal.ZERO) > 0) {
            isValid = true;
        } else {
            throw new ProductValidationException("Error! Price should be positive!");
        }
        return isValid;
    }

    @Override
    public boolean isDiscountValid(BigDecimal productDiscount) {
        BigDecimal firstLimit = new BigDecimal("0");
        BigDecimal secondLimit = new BigDecimal("100");
        boolean isValid = false;
        if (productDiscount.compareTo(firstLimit) >= 0 && productDiscount.compareTo(secondLimit) < 0) {
            isValid = true;
        } else {
            throw new ProductValidationException("Error! Enter valid discount information");
        }
        return isValid;
    }

    @Override
    public boolean isCategoryValid(Integer categoryNumber) {
        boolean isValid = false;
        if (categoryNumber >= 0 && categoryNumber <= 5) {
            isValid = true;
        } else
        {
            throw new ProductValidationException("Error! Please enter valid category number!");
        }
        return isValid;
    }

}

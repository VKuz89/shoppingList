package com.javaguru.shoppinglist.ProductService;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductValidationImplTest {
    ProductValidationImpl productValidation = new ProductValidationImpl();

    @Test
    public void nameValidationTestShortName(){
        String name = "nam";
        boolean isNameValid = productValidation.isNameValid(name);
        assertEquals(true,isNameValid);
    }
    @Test
    public void nameValidationTestLongName(){
        String name = "qwertyuiopasdfghjklzxcvbnmqwerty";
        boolean isNameValid = productValidation.isNameValid(name);
        assertEquals(true,isNameValid);
    }

    @Test
    public void priceValidationTest(){
        BigDecimal price = new BigDecimal(1);
        boolean isPriceValid = productValidation.isPriceValid(price);
        assertEquals(true,isPriceValid);
    }

    @Test
    public void discountValidationTest(){
        BigDecimal discount = new BigDecimal(99.9); // 0 - no discount
        boolean isDiscountValid = productValidation.isDiscountValid(discount);
        assertEquals(true,isDiscountValid);
        discount = new BigDecimal(0);
        isDiscountValid = productValidation.isDiscountValid(discount);
        assertEquals(true,isDiscountValid);
    }

    @Test
    public void categoryValidationTest(){
        int categoryNumber = 0;
        boolean isCategoryValid = productValidation.isCategoryValid(categoryNumber);
        assertEquals(true, isCategoryValid);
    }






}
package com.javaguru.shoppinglist.ProductService;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductValidationImplTest {
    ProductValidationImpl productValidation = new ProductValidationImpl();

    @Test
    public void test1(){
        String name = "name";
        boolean isNameValid = productValidation.isNameValid(name);
        assertEquals(true,isNameValid);
    }
    @Test
    public void test2(){
        String name = "qwertyuiopasdfghjklzxcvbnmqwerty";
        boolean isNameValid = productValidation.isNameValid(name);
        assertEquals(true,isNameValid);
    }
}
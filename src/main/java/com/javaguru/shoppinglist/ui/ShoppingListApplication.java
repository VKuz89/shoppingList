package com.javaguru.shoppinglist.ui;

import com.javaguru.shoppinglist.database.ProductRepositoryImpl;
import com.javaguru.shoppinglist.core.Product;
import com.javaguru.shoppinglist.core.ProductInitialization;
import com.javaguru.shoppinglist.core.ProductValidationImpl;

import java.math.BigDecimal;
import java.util.*;
//
class ShoppingListApplication {
    public static void main(String[] args) {
        ProductRepositoryImpl database = new ProductRepositoryImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by ID");
                System.out.println("3. Print product list");
                System.out.println("4. Delete product by ID");
                System.out.println("5. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        Product product = informationInput();
                        database.insert(product);
                        System.out.println(product);
                        break;
                    case 2:
                        Long id = idEnter();
                        System.out.println(database.read(id));
                        break;
                    case 3:
                        database.print();
                        break;
                    case 4:
                        id = idEnter();
                        database.delete(id);
                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Product informationInput() {
        ProductInitialization productInitialization = new ProductInitialization();
        Product product;
        String name = nameEnter();
        BigDecimal price = priceEnter();
        Integer categoryNumber = categoryEnter();
        BigDecimal discount = discountEnter();
        String description = descriptionEnter();
        product = productInitialization.productInit(name, price, categoryNumber, discount, description);
        return product;
    }

    public static String nameEnter() {
        Scanner scanner = new Scanner(System.in);
        ProductValidationImpl productValidation = new ProductValidationImpl();
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        productValidation.isNameValid(name);
        return name;
    }

    public static BigDecimal priceEnter() {
        Scanner scanner = new Scanner(System.in);
        ProductValidationImpl productValidation = new ProductValidationImpl();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        productValidation.isPriceValid(price);
        return price;
    }

    public static Integer categoryEnter() {
        Scanner scanner = new Scanner(System.in);
        ProductValidationImpl productValidation = new ProductValidationImpl();
        System.out.println("Enter product category: 1 - MILK; 2 - FRUITS; 3 - VEGETABLES; 4 - BREAD; 5 - FISH; " +
                "0 - no category");
        Integer categoryNumber = Integer.valueOf(scanner.nextLine());
        productValidation.isCategoryValid(categoryNumber);
        return categoryNumber;
    }

    public static BigDecimal discountEnter() {
        Scanner scanner = new Scanner(System.in);
        ProductValidationImpl productValidation = new ProductValidationImpl();
        System.out.println("Enter product discount: 0 - no discount!");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        productValidation.isDiscountValid(discount);
        return discount;
    }

    public static String descriptionEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        return description;
    }

    public static Long idEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        return id;
    }


}

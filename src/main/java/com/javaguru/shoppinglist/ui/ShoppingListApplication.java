package com.javaguru.shoppinglist.ui;

import com.javaguru.shoppinglist.core.ProductValidation;
import com.javaguru.shoppinglist.database.ProductRepositoryImpl;
import com.javaguru.shoppinglist.core.Product;
import com.javaguru.shoppinglist.core.ProductInitialization;
import com.javaguru.shoppinglist.core.ProductValidationImpl;

import java.math.BigDecimal;
import java.util.*;

class ShoppingListApplication {

    public static void main(String[] args) {
    ProductRepositoryImpl database = new ProductRepositoryImpl();


    Long productIdSequence = 0L;  // TODO: move it to ProductRepositoryImpl
        // It is Database responsibility to assign ID to newly created domain object.

    ProductInitialization productInitialization = new ProductInitialization();

    // Use interface where possible.
    ProductValidation productValidation = new ProductValidationImpl();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by ID");
                System.out.println("3. Print product list");
                System.out.println("4. Delete product by ID");
                System.out.println("5. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        // move each case code to separate method!
                        // simplify this method! If you put all code to one method this will be bad unreadable code.
                        Product product;
                            String name;
                            Integer categoryNumber;
                            BigDecimal discount;
                            BigDecimal price;

                            System.out.println("Enter product name: ");
                            name = scanner.nextLine();
                            productValidation.isNameValid(name);

                                System.out.println("Enter product price: ");
                                price = new BigDecimal(scanner.nextLine());
                                productValidation.isPriceValid(price);


                                System.out.println("Enter product category: 1 - MILK; 2 - FRUITS; 3 - VEGETABLES; 4 - BREAD; 5 - FISH; " +
                                        "0 - no category");
                                categoryNumber = Integer.valueOf(scanner.nextLine());
                                productValidation.isCategoryValid(categoryNumber);

                                System.out.println("Enter product discount: 0 - no discount!");
                                discount = new BigDecimal(scanner.nextLine());
                                productValidation.isDiscountValid(discount);


                            System.out.println("Enter product description: ");
                            String description = scanner.nextLine();

                            product = productInitialization.productInit(name,price,categoryNumber,discount,description,productIdSequence);
                            System.out.println(product.toString());

                        database.insert(productIdSequence,product);
                        productIdSequence++;
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        System.out.println(database.read(id));
                        break;
                    case 3:
                        database.print();
                        break;
                    case 4:
                        System.out.println("Enter product id: ");
                        id = scanner.nextLong();
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
}

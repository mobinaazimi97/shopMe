package com.mftplus.shopme.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {
        super("Product not found: ");
    }
}

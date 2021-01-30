package org.lab11.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<Product>();
    }

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public int getSize(){
        return products.size();
    }

    public List<Product> getProducts() {
        return products;
    }
}

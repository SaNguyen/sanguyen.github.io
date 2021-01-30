package org.lab11.model;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<User> userList;
    private List<Product> productList;
    private List<ShoppingCart> cartList;

    public Repository() {
        this.userList = new ArrayList<User>();
        userList.add(new User("sa","1"));
        userList.add(new User("do","2"));

        cartList = new ArrayList<>();

        productList = new ArrayList<>();
        productList.add(new Product(1, "blackbuck.jpeg", 10.5,
                "Black Buck"));
        productList.add(new Product(2, "house.jpeg", 11.5,
                "The House on Vesper Sands"));
        productList.add(new Product(3, "land.jpeg", 20.0,
                "Land"));
        productList.add(new Product(4, "prophet.jpeg", 25.0,
                "The Prophets"));

        productList.add(new Product(5, "ship.jpeg", 10.5,
                "A Thousand Ships"));
        productList.add(new Product(6, "shiver.jpeg", 11.5,
                "Shiver"));
        productList.add(new Product(7, "swim.jpeg", 20.0,
                "A Swim in a Pond in the Rain"));
        productList.add(new Product(8, "wife.jpeg", 25.0,
                "The Wife Upstairs: A Novel"));

    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<ShoppingCart> getCartList() {
        return cartList;
    }

    public boolean findUser(String name, String pass){
        User user = new User(name, pass);
        return userList.contains(user);
    }

    public boolean findUser(User user){
        return userList.contains(user);
    }

    public Product findProductById(Integer Id){
        for(Product p :productList){
            if(p.getId() == Id){
                return p;
            }
        }
        return null;
    }
}

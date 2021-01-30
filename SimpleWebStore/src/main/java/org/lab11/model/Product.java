package org.lab11.model;

public class Product {
    private Integer id;
    private String image;
    private Double price;
    private String title;

    public Product(Integer id, String image, Double price, String title) {
        this.id = id;
        this.image = image;
        this.price = price;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public Double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

}

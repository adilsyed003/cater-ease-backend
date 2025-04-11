package com.catering.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "items")
public class Item {
    @Id
    private String id;
    private String name;
    private String description;
    private List<String> dishes;
    private List<Double> prices;
    public Item() {}

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.dishes = new ArrayList<String>();
        this.prices = new ArrayList<>();
    }


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<String> getDishes() { return dishes; }
    public List<Double> getPrices() { return prices; }
    public void setPrices(List<Double> prices) { this.prices = prices; }
}
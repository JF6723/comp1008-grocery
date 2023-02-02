package com.example.groceryexample;

import java.util.Arrays;
import java.util.List;

public class GroceryItem {
    //These are the instance variables.  These track the "attributes" of the
    //object
    private String name;
    private double price;
    private String category;

    /**
     * This is a constructor.  It's job is to initialize the instance variables
     * and have the system allocate memory to store the object
     */
    public GroceryItem(String name, double price, String category) {
        setName(name);
        setPrice(price);
        setCategory(category);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isBlank())
            this.name = name;
        else
            throw new IllegalArgumentException("name cannot be blank");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price>0 && price<=2000)
            this.price = price;
        else
            throw new IllegalArgumentException("price must be in the range of 0.01 to 2000");
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        List<String> categories = Arrays.asList("meat","fruit","vegetables","dairy","bread");

        if (categories.contains(category))
            this.category = category;
        else
            throw new IllegalArgumentException(category + " was received, argument must be " +
                    "from the list "+ categories);
    }

    public String toString()
    {
        return String.format("%s",name);
    }
}

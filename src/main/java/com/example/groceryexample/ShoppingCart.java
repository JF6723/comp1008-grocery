package com.example.groceryexample;

import java.util.ArrayList;
import java.util.TreeSet;

public class ShoppingCart {
    private ArrayList<GroceryItem> cart;

    public ShoppingCart()
    {
        cart = new ArrayList<>();
    }

    /**
     * This will add a GroceryItem to the cart
     */
    public void addGroceryItem(GroceryItem groceryItem)
    {
        cart.add(groceryItem);
    }

    /**
     * This will return the total price of the items in the
     * shopping cart (minus taxes)
     */
    public double getTotalPrice()
    {
        double total = 0;

        for (GroceryItem groceryItem : cart)
            total += groceryItem.getPrice();

        return total;
    }

    /**
     * This method will remove the specified object from the cart
     * (if it is in the cart), it will do nothing if not found
     */
    public void removeGroceryItem(GroceryItem item)
    {
        cart.remove(item);
    }

    public String toString()
    {
        return String.format("Cart has %d items with a total cost of: $%.2f",cart.size(),
                                getTotalPrice());
    }

    public String getGroceryNames()
    {
        String groceryNames = "";

        for (GroceryItem groceryItem : cart)
            groceryNames += groceryItem.getName()+", ";

        return groceryNames.substring(0,groceryNames.length()-2);
    }

    public String getCategories()
    {
        String categories = "";

        for (GroceryItem groceryItem : cart) {
            if (!categories.contains(groceryItem.getCategory()))
                categories += groceryItem.getCategory() + ", ";
        }

        return categories.substring(0,categories.length()-2);

//        TreeSet<String> categories = new TreeSet<>();
//        for (GroceryItem groceryItem : cart)
//            categories.add(groceryItem.getCategory());
//
//        return categories.toString();
    }

    public ArrayList<GroceryItem> getCart() {
        return cart;
    }
}

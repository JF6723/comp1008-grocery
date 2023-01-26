package com.example.groceryexample;

public class Main {
    public static void main(String[] args) {

        //This is creating a new object (aka creating a new instance of the class or
        //some people call this "instantiating" the class)
        GroceryItem carrots = new GroceryItem("carrots",4.79,"vegetables");
        GroceryItem bread = new GroceryItem("bread",2.89,"bread");
        GroceryItem ryeBread = new GroceryItem("rye bread",3.89,"bread");
        GroceryItem fish = new GroceryItem("salmon",12.89,"meat");
        GroceryItem iceCream = new GroceryItem("ice cream",7.79,"dairy");

        ShoppingCart cart = new ShoppingCart();
        cart.addGroceryItem(carrots);
        cart.addGroceryItem(bread);
        cart.addGroceryItem(fish);
        cart.addGroceryItem(iceCream);
        cart.addGroceryItem(ryeBread);
        System.out.printf("The total price of the cart is: $%.2f%n",cart.getTotalPrice());
        cart.removeGroceryItem(iceCream);
        System.out.printf("The total price of the cart is: $%.2f%n",cart.getTotalPrice());

        System.out.println(cart);
        System.out.println(cart.getGroceryNames());
        System.out.println(cart.getCategories());
    }
}

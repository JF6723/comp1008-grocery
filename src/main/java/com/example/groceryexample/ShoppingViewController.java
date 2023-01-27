package com.example.groceryexample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.security.SecureRandom;
import java.util.*;

public class ShoppingViewController implements Initializable {

    @FXML
    private ListView<GroceryItem> cartItemsListView;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private Label categoryLabel;

    @FXML
    private ListView<GroceryItem> groceryListView;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label totalLabel;

    private ShoppingCart cart;

    @FXML
    void addToCart(ActionEvent event) {
        GroceryItem itemSelected = groceryListView.getSelectionModel().getSelectedItem();
        if (itemSelected != null){
            cart.addGroceryItem(itemSelected);
            totalLabel.setText(String.format("Total Price: $%.2f",cart.getTotalPrice()));
            cartItemsListView.getItems().clear();
            cartItemsListView.getItems().addAll(cart.getCart());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cart = new ShoppingCart();
        totalLabel.setText(String.format("Total Price: $.2f",cart.getTotalPrice()));

        updateLabels(null);
        ArrayList<GroceryItem> inventory = new ArrayList<>();
        TreeMap<String, List<String>> food = new TreeMap<>();
        food.put("bread", Arrays.asList("rye bread","white bread","whole wheat", "cereal"));
        food.put("meat",Arrays.asList("rib steak","salmon","ground beef","hot dogs","bacon"));
        food.put("vegetables", Arrays.asList("brocolli","cucumber","potato","sweet potato"));
        food.put("dairy",Arrays.asList("ice cream","2% milk","3.25% milk","chocolate milk"));

        SecureRandom rng = new SecureRandom();
        for (String category : food.keySet())
        {
            for (String foodName : food.get(category))
            {
                inventory.add(new GroceryItem(foodName,rng.nextDouble(2,20),category));
            }
        }

        Collections.sort(inventory, new Comparator<GroceryItem>() {
            @Override
            public int compare(GroceryItem o1, GroceryItem o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        categoryComboBox.getItems().add("All Categories");
        categoryComboBox.getItems().addAll(food.keySet());
        categoryComboBox.valueProperty().addListener((obs, old, categorySelected)->{
            groceryListView.getItems().clear();
            if (categorySelected.equals("All Categories"))
                groceryListView.getItems().addAll(inventory);
            else
            {
                for (GroceryItem groceryItem : inventory)
                {
                    if (groceryItem.getCategory().equals(categorySelected))
                        groceryListView.getItems().add(groceryItem);
                }
            }
        });

        groceryListView.getItems().addAll(inventory);

        groceryListView.getSelectionModel().selectedItemProperty().addListener((obs, old, itemSelected)->{
            updateLabels(itemSelected);
        });
    }

    private void updateLabels(GroceryItem itemSelected)
    {
        if (itemSelected != null)
        {
            nameLabel.setText("Name: "+itemSelected.getName());
            priceLabel.setText(String.format("Price: $%.2f",itemSelected.getPrice()));
            categoryLabel.setText(String.format("Category: %s",itemSelected.getCategory()));
        }
        else
        {
            nameLabel.setText("");
            categoryLabel.setText("");
            priceLabel.setText("");
        }
    }
}

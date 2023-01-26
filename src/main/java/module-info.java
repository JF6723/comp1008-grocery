module com.example.groceryexample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.groceryexample to javafx.fxml;
    exports com.example.groceryexample;
}
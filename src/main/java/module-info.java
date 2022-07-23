module com.example.comp1011m2022ice9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;
    requires java.net.http;




    opens com.example.comp1011m2022ice9 to javafx.fxml, com.google.gson;
    exports com.example.comp1011m2022ice9;
}
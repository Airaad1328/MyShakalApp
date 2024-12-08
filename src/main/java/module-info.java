module com.gmail.clarkin200.myshakalapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.gmail.clarkin200.myshakalapp to javafx.fxml;
    exports com.gmail.clarkin200.myshakalapp;
}
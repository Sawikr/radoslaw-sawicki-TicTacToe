module com.kodilla{

    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.net.http;
    requires java.desktop;

    opens com.kodilla.tictactoe.running.javafxboard to javafx.fxml;
    exports com.kodilla.tictactoe.running.javafxboard;
}
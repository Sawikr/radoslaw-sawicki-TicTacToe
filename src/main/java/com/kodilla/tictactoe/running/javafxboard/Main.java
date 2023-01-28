package com.kodilla.tictactoe.running.javafxboard;

import com.kodilla.tictactoe.running.javafxboard.gameoption.GameOptionConsoleOrJavaFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static com.kodilla.tictactoe.running.javafxboard.Controller.closeProgram;

/**
 * @author Radoslaw Sawicki
 * @version 1.0.1
 * @apiNote Program with javaFX
 * @apiNote Task: 9.2
 */

public class Main extends Application {

    public static Boolean javaFx = false;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/templates/sample.fxml"));//File sample.fxml must be in templates!
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Game: Tic-Tac-Toe!");
        stage.setScene(scene);
        stage.show();
        endGame(stage);

    }

    //Method is not necessary!
    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void endGame(Stage stage) {
        stage.setOnCloseRequest(e -> {
            e.consume();
            try {
                Main main = new Main();
                main.stop();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            closeProgram(stage);
        });
    }

    public static void main(String[] args) {

        GameOptionConsoleOrJavaFx.gameChoice();
        if (javaFx)
            launch(args);
    }
}

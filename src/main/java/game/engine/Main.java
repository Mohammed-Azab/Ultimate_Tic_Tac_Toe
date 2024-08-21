package game.engine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage)  {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/game.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/GameIntroAssest.png")));
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("Dice Realms");
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(false);
            primaryStage.setFullScreenExitHint("");
            primaryStage.setFullScreenExitKeyCombination(javafx.scene .input.KeyCombination.valueOf("q"));
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}

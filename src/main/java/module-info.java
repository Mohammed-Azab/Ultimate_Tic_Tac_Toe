module ultimate.tic.tac.toe {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.media;

    opens game.GUI to javafx.fxml;
    exports game.engine to javafx.graphics;

}

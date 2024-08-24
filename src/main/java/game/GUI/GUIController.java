package game.GUI;

import game.engine.CLIController;
import game.entity.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

import static game.GUI.FxmlController.*;


public class GUIController extends CLIController {
    public static FxmlController fxmlController;
    public static GUIController guiController;



    public GUIController() {
        super();
        guiController=this;
    }

    public void start(){
        startGameRoutine();
    }

    private void startGameRoutine() {
        while (getGameStatus()== GameStatus.Ongoing){ // needs to be stated not Game Loop
            // Alert for which Shape for X,O is wanted
            // Alert For which player is playing
            fxmlController.changePlayerToGo(getCurrentPlayer().getName());
            fxmlController.doTheInterrupt();
            X = new ImageView();
            O = new ImageView();
            try {
                X.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/XRed.png"))));
                O.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/OBlue.png"))));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            Player currentPlayer =getCurrentPlayer();
            if (currentPlayer==getPlayer1()){
                currentPlayer= getPlayer2();
            }
            else {
                currentPlayer= getPlayer1();
            }
        }
        startEndGameRoutine();
    }

    private void startEndGameRoutine() {
        if (getPlayer2().isAiPlayer()){
            if (getPlayer2().getPlayerState()==PlayerState.WON){
                fxmlController.playDefeatedSound();
            }
            else {
                fxmlController.playVictorySound();
            }
        }
        else {
            fxmlController.playVictorySound();
        }
        // Display who won
    }



    public void makeMove(){
        int i= (currentCellNumber/10)-1;
        int j= currentCellNumber%10;
        Cell currentCell= getBoard().getMiniBoard(i,j).getCell(i,j);
        if (currentCell.isOccupied() || currentCell.getState()== CellState.Disabled){
            return;
        }
        Mark currentMark = getCurrentPlayer().getMark();
        currentCell.putMark(currentMark);
        ImageView imageView = new ImageView();
        switch (currentMark){
            case X:
                imageView.setImage(X.getImage()); break;
            case O:
                imageView.setImage(O.getImage()); break;
            default:
                return;
        }
        Rectangle rectangle= fxmlController.getCurrentRectangle();
        imageView.setX(rectangle.getX());
        imageView.setY(rectangle.getY());
        imageView.setLayoutX(rectangle.getLayoutX());
        imageView.setLayoutY(rectangle.getLayoutY());
        fxmlController.root.getChildren().add(imageView);
        fxmlController.root.getChildren().remove(rectangle);
        fxmlController.playSoundOfPlay();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (getBoard().getMiniBoard(i,j).hasWinner()){ // check if the miniBoard has a winner
            ImageView currentImage = new ImageView();
            Mark winnerMark= getBoard().getMiniBoard(i,j).getWinnerMark();
            switch (winnerMark){
                case X:
                    currentImage= X; break;
                case O:
                    currentImage= O; break;
                default:
                    break;
            }
            fxmlController.changeImage(i-1,currentImage);
        }
        fxmlController.releaseTheInterrupt();
    }

}

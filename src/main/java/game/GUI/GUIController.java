package game.GUI;

import game.engine.CLIController;
import game.entity.*;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.Objects;
import java.util.ResourceBundle;

public class GUIController implements Initializable {
    public ImageView C, C1, C2, C3, C4, C5, C6, C7, C8;
    public Rectangle r1,r2,r3,r4,r5,r6,r7,r8,r9;
    public Rectangle r11,r12,r13,r14,r15,r16,r17,r18;
    public Rectangle r21,r22,r23,r24,r25,r26,r27,r28;
    public Rectangle r31,r32,r33,r34,r35,r36,r37,r38;
    public Rectangle r41,r42,r43,r44,r45,r46,r47,r48;
    public Rectangle r51,r52,r53,r54,r55,r56,r57,r58;
    public Rectangle r61,r62,r63,r64,r65,r66,r67,r68;
    public Rectangle r71,r72,r73,r74,r75,r76,r77,r78;
    public Rectangle r81,r82,r83,r84,r85,r86,r87,r88;
    public Rectangle r91,r92,r93,r94,r95,r96,r97,r98;
    public AnchorPane root;

    private CLIController controller;
    ImageView X;
    ImageView O;
    int currentCellNumber;
    Rectangle [][] rectangles;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller= new CLIController();
        controller.getPlayer1().setName("Player1");
        controller.getPlayer2().setName("Player2");
        controller.getPlayer1().setMark(Mark.X);
        controller.getPlayer1().setMark(Mark.O);
        rectangles = new Rectangle[9][9];
        startGameRoutine();
        startEndGameRoutine();
    }

    private void startGameRoutine() {
        while (controller.getGameStatus()==GameStatus.Ongoing){ // needs to be stated not Game Loop
            // Alert for which Shape for X,O is wanted
            // Alert For which player is playing
            X = new ImageView();
            O = new ImageView();
            try {
                X.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/XRed.png"))));
                O.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/OBlue.png"))));
            }
            catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    private void startEndGameRoutine() {
        if (controller.getPlayer2().isAiPlayer()){
            if (controller.getPlayer2().getPlayerState()==PlayerState.WON){
                playDefeatedSound();
            }
            else {
                playVictorySound();
            }
        }
        else {
            playVictorySound();
        }

        // Display who won
    }

    private void makeMove(){
        int i= (currentCellNumber/10)-1;
        int j= currentCellNumber%10;
        Cell currentCell= controller.getBoard().getMiniBoard(i,j).getCell(i,j);
        if (currentCell.isOccupied() || currentCell.getState()== CellState.Disabled){
            return;
        }
        Mark currentMark = controller.getCurrentPlayer().getMark();
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
        Rectangle rectangle= getCurrentRectangle();
        imageView.setX(rectangle.getX());
        imageView.setY(rectangle.getY());
        imageView.setLayoutX(rectangle.getLayoutX());
        imageView.setLayoutY(rectangle.getLayoutY());
        root.getChildren().add(imageView);
        root.getChildren().remove(rectangle);
        playSoundOfPlay();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (controller.getBoard().getMiniBoard(i,j).hasWinner()){ // check if the miniBoard has a winner
            ImageView currentImage = new ImageView();
            Mark winnerMark= controller.getBoard().getMiniBoard(i,j).getWinnerMark();
            switch (winnerMark){
                case X:
                    currentImage= X; break;
                    case O:
                        currentImage= O; break;
                        default:
                            break;
            }
            changeImage(i-1,currentImage);
        }


    }

    private void changeImage(int i,ImageView currentImage){
        switch (i){
            case 0:
                C.setImage(currentImage.getImage()); break;
                case 1:
                    C1.setImage(currentImage.getImage()); break;
                    case 2:
                        C2.setImage(currentImage.getImage()); break;
                        case 3:
                            C3.setImage(currentImage.getImage()); break;
                            case 4:
                                C4.setImage(currentImage.getImage()); break;
                                case 5:
                                    C5.setImage(currentImage.getImage()); break;
                                    case 6:
                                        C6.setImage(currentImage.getImage()); break;
                                        case 7:
                                            C7.setImage(currentImage.getImage()); break;
                                            case 8:
                                                C8.setImage(currentImage.getImage()); break;
                                                default:
                                                    break;

        }
    }

    public void setCurrentCellNumber(MouseEvent mouseEvent) {
        Object source = mouseEvent.getSource();
        int num = -1;

        if (source instanceof Rectangle) {
            Rectangle clickedRectangle = (Rectangle) source;
            String rectangleName = clickedRectangle.getId();
            rectangleName = rectangleName.substring(1);
            num = Integer.parseInt(rectangleName);
        }
        if (num == -1) {
            return;
        }
        currentCellNumber = num;
    }


    public void highlight(MouseEvent mouseEvent) { // on mouse entered
        int i= (currentCellNumber/10)-1;
        int j= currentCellNumber%10;
        Cell currentCell= controller.getBoard().getMiniBoard(i,j).getCell(i,j);
        if (currentCell.isOccupied() || currentCell.getState()== CellState.Disabled){
            return;
        }
        Rectangle rectangle = getCurrentRectangle();

        if (rectangle != null) {
            rectangle.setVisible(true);
        }
    }

    public void resetHighlight(MouseEvent mouseEvent) { // on mouse Exist
        Rectangle rectangle = getCurrentRectangle();

        if (rectangle != null) {
            rectangle.setVisible(false);
        }
    }

    private Rectangle getCurrentRectangle(){
        String id= currentCellNumber+"";
        if (currentCellNumber==0){
            id="r";
        }
        else if (currentCellNumber%10==0){
            id="r"+currentCellNumber/10;
        }
        return (Rectangle) root.lookup("#" + id);
    }

    private void playSoundOfPlay() {
        String soundFilePath = "/sounds/click.wav";
        AudioClip sound = new AudioClip(Objects.requireNonNull(getClass().getResource(soundFilePath)).toString());
        sound.play();
    }
    private void playVictorySound() {
        String soundFilePath = "/sounds/victory.wav";
        AudioClip sound = new AudioClip(Objects.requireNonNull(getClass().getResource(soundFilePath)).toString());
        sound.play();
    }
    private void playDefeatedSound() {
        String soundFilePath = "/sounds/lose.wav";
        AudioClip sound = new AudioClip(Objects.requireNonNull(getClass().getResource(soundFilePath)).toString());
        sound.play();
    }



}

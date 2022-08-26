import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class GameControls {

    Logic logic = new Logic();
    private final Color colorControlsBackground = Color.rgb(164, 176, 190);
    private Rectangle controlsBackground;
    private Font font = new Font("Times New Roman",40);
    private Image image;
    private ImageView imageView;

    GameControls(){
        generateControlsBackground();
        generateControls();
        logic.generateInfoSpace();
    }

    public void generateControlsBackground(){
        controlsBackground = new Rectangle(890, 10, 400, 870);
        controlsBackground.setFill(colorControlsBackground);
        controlsBackground.setStroke(Color.BLACK);
        controlsBackground.setStrokeWidth(3);
        MyPane.getGameRoot().getChildren().add(controlsBackground);
    }

    public void generateControls(){
        GameButton rollDiceButton = new GameButton("Würfeln", 910, 120);
        rollDiceButton.setFont(font);
        rollDiceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                logic.move();
            }
        });
        GameButton endMoveButton = new GameButton("Zug Beenden", 910, 358);
        endMoveButton.setFont(font);
        endMoveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                MyPane.getGameRoot().getChildren().remove(logic.getImageView());
                logic.deactivateFigures();
                logic.getRollDiceButton().setDisable(false);
                logic.nextPlayer();
                logic.displayInfoSpace();
            }
        });
        GameButton exitButton = new GameButton("Spiel beenden", 910, 790);
        exitButton.setFont(font);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                MyStage.getStage().close();
            }
        });
        MyPane.getGameRoot().getChildren().addAll(rollDiceButton, endMoveButton, exitButton);

        image = new Image("design/icon.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(174);
        imageView.setFitHeight(174);
        imageView.setTranslateX(1006);
        imageView.setTranslateY(522);
        MyPane.getGameRoot().getChildren().addAll(imageView);

        logic.setRollDiceButton(rollDiceButton);
    }

}

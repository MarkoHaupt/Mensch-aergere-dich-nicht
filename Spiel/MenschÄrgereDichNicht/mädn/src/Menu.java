import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Menu {

    private Game game = new Game();

    private final int WIDTH = 1300;
    private final int HEIGHT = 890;
    private Image image = new Image("design/menuBackground.png");
    private BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    Menu(){
        MyPane.getMenuRoot().setBackground(new Background(backgroundImage));
        MenuButton playButton = new MenuButton("PLAY", 483, 435);
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                MySceen.getScene().setRoot(MyPane.getGameRoot());
            }
        });
        MenuButton exitButton = new MenuButton("EXIT", 483, 578);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                MyStage.getStage().close();
            }
        });
        MyPane.getMenuRoot().getChildren().addAll(playButton, exitButton);
    }

}

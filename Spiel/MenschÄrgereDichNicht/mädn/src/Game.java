import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Game {

    GameControls gameControls = new GameControls();
    private final Color colorGameBackground = Color.rgb(116, 125, 140);
    private Rectangle gameBackground;
    private final int WIDTH = 1300;
    private final int HEIGHT = 890;

    public GameControls getGameControls() {
        return gameControls;
    }

    Game(){
        generateGameBackground();
    }

    public void generateGameBackground(){
        gameBackground = new Rectangle(WIDTH, HEIGHT);
        gameBackground.setFill(colorGameBackground);
        gameBackground.setViewOrder(10);
        MyPane.getGameRoot().getChildren().add(gameBackground);
    }

}

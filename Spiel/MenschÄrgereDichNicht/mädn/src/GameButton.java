import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class GameButton extends Button {

    private final int WIDTH = 360;
    private final int HEIGHT = 70;
    private Font buttonFont = new Font("Arial",32);

    GameButton(String text, int x, int y){
        super(text);
        GameButton.super.setFont(buttonFont);
        GameButton.super.setTranslateX(x);
        GameButton.super.setTranslateY(y);
        GameButton.super.setMinSize(WIDTH, HEIGHT);
        GameButton.super.setMaxSize(WIDTH, HEIGHT);
    }

}

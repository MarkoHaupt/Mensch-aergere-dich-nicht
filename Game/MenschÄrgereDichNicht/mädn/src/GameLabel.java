import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class GameLabel extends Label {

    private final int WIDTH = 360;
    private final int HEIGHT = 70;
    private Font labelFont = new Font("Arial",32);

    GameLabel(String text, int x, int y){
        super(text);
        GameLabel.super.setFont(labelFont);
        GameLabel.super.setTranslateX(x);
        GameLabel.super.setTranslateY(y);
        GameLabel.super.setMinSize(WIDTH, HEIGHT);
        GameLabel.super.setMaxSize(WIDTH, HEIGHT);
        GameLabel.super.setAlignment(Pos.CENTER);
    }

}

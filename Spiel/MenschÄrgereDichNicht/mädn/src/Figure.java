import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Figure extends Button {

    private final int WIDTH = 60;
    private final int HEIGHT = 60;
    private final Font font = new Font("Arial",32);

    Figure(int x, int y){
        Figure.super.setText("");
        Figure.super.setTranslateX(x);
        Figure.super.setTranslateY(y);
        Figure.super.setMinSize(WIDTH, HEIGHT);
        Figure.super.setMaxSize(WIDTH, HEIGHT);
        Figure.super.setFont(font);
    }


}

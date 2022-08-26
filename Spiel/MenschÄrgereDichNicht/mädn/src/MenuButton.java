import javafx.scene.control.Button;
import javafx.scene.text.Font;


public class MenuButton extends Button {

    private final int WIDTH = 307;
    private final int HEIGHT = 105;
    private Font buttonFont = new Font("Times New Roman",64);

    MenuButton(String text, int x, int y){
        super(text);
        MenuButton.super.setTranslateX(x);
        MenuButton.super.setTranslateY(y);
        MenuButton.super.setMinWidth(WIDTH);
        MenuButton.super.setMinHeight(HEIGHT);
        MenuButton.super.setMaxWidth(WIDTH);
        MenuButton.super.setMaxHeight(HEIGHT);
        MenuButton.super.setFont(buttonFont);
    }

}

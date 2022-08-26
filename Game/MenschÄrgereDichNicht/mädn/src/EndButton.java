import javafx.scene.control.Button;
import javafx.scene.text.Font;


public class EndButton extends Button {

    private final int WIDTH = 323;
    private final int HEIGHT = 141;
    private Font buttonFont = new Font("Times New Roman",80);

    EndButton(String text, int x, int y){
        super(text);
        EndButton.super.setTranslateX(x);
        EndButton.super.setTranslateY(y);
        EndButton.super.setMinWidth(WIDTH);
        EndButton.super.setMinHeight(HEIGHT);
        EndButton.super.setMaxWidth(WIDTH);
        EndButton.super.setMaxHeight(HEIGHT);
        EndButton.super.setFont(buttonFont);
    }

}

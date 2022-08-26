import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class EndLabel extends Label {

    private final int WIDTH = 1063;
    private final int HEIGHT = 365;
    private Font labelFont = new Font("Times New Roman",96);

    EndLabel(String text, int x, int y){
        super(text);
        EndLabel.super.setFont(labelFont);
        EndLabel.super.setTranslateX(x);
        EndLabel.super.setTranslateY(y);
        EndLabel.super.setMinSize(WIDTH, HEIGHT);
        EndLabel.super.setMaxSize(WIDTH, HEIGHT);
        EndLabel.super.setAlignment(Pos.CENTER);
    }

}

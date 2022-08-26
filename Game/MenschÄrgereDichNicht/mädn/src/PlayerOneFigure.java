import javafx.scene.paint.Color;

public class PlayerOneFigure extends Figure{

    PlayerOneFigure(int x, int y) {
        super(x, y);
        PlayerOneFigure.super.setStyle("-fx-background-color: rgb(0, 52, 142); -fx-background-radius: 30; -fx-background-inset: 2; -fx-border-color:black; -fx-border-width: 3; -fx-border-radius: 30;");
    }

}

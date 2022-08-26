import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class PlayerTwoField extends Field{

    private Stop[] stops = {
            new Stop(0, Color.rgb(255,197,63)),
            new Stop(1, Color.rgb(236,186,18))
    };
    private LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

    PlayerTwoField(int x, int y) {
        super(x, y);
        PlayerTwoField.super.setFill(gradient);
    }

}

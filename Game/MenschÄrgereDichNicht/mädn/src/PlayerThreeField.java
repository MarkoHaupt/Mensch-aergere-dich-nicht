import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class PlayerThreeField extends Field{

    private Stop[] stops = {
            new Stop(0, Color.rgb(246,132,66)),
            new Stop(1, Color.rgb(232,110,26))
    };
    private LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

    PlayerThreeField(int x, int y){
        super(x, y);
        PlayerThreeField.super.setFill(gradient);
    }

}

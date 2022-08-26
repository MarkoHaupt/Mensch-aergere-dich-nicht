import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class PlayerFourField extends Field{

    private Stop[] stops = {
            new Stop(0, Color.rgb(102,166,56)),
            new Stop(1, Color.rgb(123,181,93))
    };
    private LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

    PlayerFourField(int x, int y){
        super(x, y);
        PlayerFourField.super.setFill(gradient);
    }

}

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class PlayerOneField extends Field{

    private Stop[] stops = {
            new Stop(0, Color.rgb(54,101,196)),
            new Stop(1, Color.rgb(85,127,204))
    };
    private LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

    PlayerOneField(int x, int y){
        super(x, y);
        PlayerOneField.super.setFill(gradient);
    }

}

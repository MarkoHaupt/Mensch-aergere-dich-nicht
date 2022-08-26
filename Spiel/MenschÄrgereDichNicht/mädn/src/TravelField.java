import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class TravelField extends Field{

    private Stop[] stops = {
            new Stop(0, Color.rgb(194,194,194)),
            new Stop(1, Color.rgb(193,193,193))
    };
    private LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

    TravelField(int x, int y){
        super(x, y);
        TravelField.super.setFill(gradient);
    }

}

import javafx.scene.shape.Rectangle;

public class Field extends Rectangle {

    private final int WIDTH = 70;
    private final int HEIGHT = 70;

    Field(int x, int y){
        Field.super.setTranslateX(x);
        Field.super.setTranslateY(y);
        Field.super.setWidth(WIDTH);
        Field.super.setHeight(HEIGHT);
    }

    Field(){

    }

}

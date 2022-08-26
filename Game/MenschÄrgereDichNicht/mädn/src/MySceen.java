import javafx.scene.Scene;

public abstract class MySceen {

    private static Scene scene = new Scene(MyPane.getMenuRoot(), 1300, 890);

    public static Scene getScene() {
        return scene;
    }
}

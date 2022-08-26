import javafx.stage.Stage;

public abstract class MyStage {

    private static Stage stage = new Stage();

    public static Stage getStage() {
        return stage;
    }
}

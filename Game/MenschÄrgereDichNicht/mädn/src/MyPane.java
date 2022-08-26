import javafx.scene.layout.Pane;

public abstract class MyPane {

    private static Pane gameRoot = new Pane();
    private static Pane menuRoot = new Pane();
    private static Pane endRoot = new Pane();

    public static Pane getMenuRoot() {
        return menuRoot;
    }

    public static Pane getGameRoot() {
        return gameRoot;
    }

    public static Pane getEndRoot() {
        return endRoot;
    }

}

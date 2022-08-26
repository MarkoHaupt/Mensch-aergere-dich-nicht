import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private Menu menu = new Menu();

    @Override
    public void start(Stage originalStage) throws Exception{

        //---------------------------------------------------------------------------------------------------Stage stuff
        Image icon = new Image("design/icon.png");
        MyStage.getStage().getIcons().add(icon);
        MyStage.getStage().setTitle("Mensch ärgere Dich nicht");
        MyStage.getStage().setResizable(false);

        //-----------------------------------------------------------------------------------------------Finishing stuff
        MyStage.getStage().setScene(MySceen.getScene());
        MyStage.getStage().show();

    }

    public static void main(String[] args){
        launch(args);
    }

}

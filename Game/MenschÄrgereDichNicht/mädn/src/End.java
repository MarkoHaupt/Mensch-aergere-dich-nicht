import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class End {

    private final int WIDTH = 1300;
    private final int HEIGHT = 890;
    private Image image = new Image("design/endBackground.png");
    private BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    private EndLabel winnerLabel;
    private EndButton exitButton;

    public EndLabel getWinnerLabel() {
        return winnerLabel;
    }

    End(){
        MyPane.getEndRoot().setBackground(new Background(backgroundImage));
        winnerLabel = new EndLabel("", 120, 100);

        exitButton = new EndButton("EXIT", 478, 586);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                MyStage.getStage().close();
            }
        });
        MyPane.getEndRoot().getChildren().addAll(winnerLabel, exitButton);
    }

}

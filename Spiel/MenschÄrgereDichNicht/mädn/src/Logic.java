import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Logic {

    private End end = new End();

    private MatchField matchField = new MatchField();
    private GameButton rollDiceButton;
    private GameLabel activePlayerDisplay;

    private Font font = new Font("Times New Roman",44);
    private int[][] figuresTraveled = new int[4][4];
    private int activePlayer = 0;
    private int dieResult = 0;
    private int rolledDice = 0;

    private Image dice;
    private ImageView imageView;

    Logic(){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                figuresTraveled[0][0] = 0;
            }
        }
    }

    public void setRollDiceButton(GameButton rollDiceButton) {
        this.rollDiceButton = rollDiceButton;
    }

    public GameButton getRollDiceButton() {
        return rollDiceButton;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void move(){//-------------------------------------------------------------------------------------------an sich der start

        //for end testing
        //moveFigureToField(0, 0, matchField.getFinishFields()[0][0]);
        //moveFigureToField(0, 1, matchField.getFinishFields()[0][1]);
        //moveFigureToField(0, 2, matchField.getFinishFields()[0][2]);
        //moveFigureToField(0, 3, matchField.getFinishFields()[0][3]);
        //checkForWin(activePlayer);
        //end of for end testing

        rolledDice++;
        dieResult = rollDice();
        displayDieResult();
        if(!homeIsFull(activePlayer) || rolledDice >= 3){
            getRollDiceButton().setDisable(true);
        }
        for (int i = 0; i < 4; i++) {
            if(moveIsPossible(activePlayer, i)) {
                activateFigure(i);
            }
        }
    }

    public void activateFigure(int figure){
        matchField.getFigures()[activePlayer][figure].setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if(figureIsAtHome(activePlayer, figure) && dieResult==6){
                    moveFigureToField(activePlayer, figure, matchField.getStartFields()[activePlayer]);
                    figuresTraveled[activePlayer][figure]++;
                }else {
                    if(figuresTraveled[activePlayer][figure]+dieResult > 40){
                        moveFigureToField(activePlayer, figure, matchField.getFinishFields()[activePlayer][figuresTraveled[activePlayer][figure]+dieResult-41]);
                    }else if(getNumericalPostionOfFigure(activePlayer, figure)+dieResult>39){
                        moveFigureToField(activePlayer, figure, matchField.getTravelFields()[getNumericalPostionOfFigure(activePlayer, figure)+dieResult-40]);
                    }else {
                        moveFigureToField(activePlayer, figure, matchField.getTravelFields()[getNumericalPostionOfFigure(activePlayer, figure)+dieResult]);
                    }
                    figuresTraveled[activePlayer][figure] += dieResult;
                }
                ifPossibleSchmeißFigure(activePlayer, figure);
                checkForWin(activePlayer);
                //--------------------------------------------------------------------------------------------------------------stuff after move
                MyPane.getGameRoot().getChildren().remove(imageView);
                deactivateFigures();

                if((!homeIsFull(activePlayer) || rolledDice >= 3) ^ dieResult==6){
                    nextPlayer();
                }
                rollDiceButton.setDisable(false);
                displayInfoSpace();
            }
        });
    }

    public void deactivateFigures(){
        for(int i=0; i<4; i++){
            matchField.getFigures()[activePlayer][i].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {

                }
            });
        }
    }

    public void checkForWin(int activePlayer){
        int counter = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(getFieldOfFigure(activePlayer, i).equals(matchField.getFinishFields()[activePlayer][j])){
                    counter++;
                }
            }
        }
        if(counter==4){
            if(activePlayer==0){
                end.getWinnerLabel().setText("Blau hat gewonnen!");
            }else if(activePlayer==1){
                end.getWinnerLabel().setText("Gelb hat gewonnen!");
            }else if(activePlayer==2){
                end.getWinnerLabel().setText("Orange hat gewonnen!");
            }else if(activePlayer==3){
                end.getWinnerLabel().setText("Grün hat gewonnen!");
            }
            MySceen.getScene().setRoot(MyPane.getEndRoot());
        }
    }

    public void ifPossibleSchmeißFigure(int activePlayer, int figure){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if((matchField.getFigures()[activePlayer][figure].getTranslateX() == matchField.getFigures()[i][j].getTranslateX()) && (matchField.getFigures()[activePlayer][figure].getTranslateY() == matchField.getFigures()[i][j].getTranslateY()) && (i!=activePlayer)){
                    moveFigureToField(i, j, matchField.getHomeFields()[i][j]);
                    figuresTraveled[i][j]=0;
                }
            }
        }
    }

    public int getNumericalPostionOfFigure(int activePlayer, int figure){
        int result = 99;
        for(int i=0; i<40; i++){
            if(getFieldOfFigure(activePlayer, figure).equals(matchField.getTravelFields()[i])){
                result = i;
            }
        }
        return result;
    }

    public void moveFigureToField(int activePlayer, int figure, Field destination){
        matchField.getFigures()[activePlayer][figure].setTranslateX(destination.getTranslateX()+5);
        matchField.getFigures()[activePlayer][figure].setTranslateY(destination.getTranslateY()+5);
    }

    public boolean moveIsPossible(int activePlayer, int figure){
        boolean result = true;
        if(!getFieldOfFigure(activePlayer, figure).equals(matchField.getHomeFields()[activePlayer][figure])) {
            for (int i = 0; i < 4; i++) {
                if ((figuresTraveled[activePlayer][figure] + dieResult == figuresTraveled[activePlayer][i]) && (i != figure)) {
                    result = false;
                }
            }
        }
        if(dieResult == 6 && getFieldOfFigure(activePlayer, figure).equals(matchField.getHomeFields()[activePlayer][figure])){
            for(int i=0; i<4; i++){
                if((figuresTraveled[activePlayer][figure]+1 == figuresTraveled[activePlayer][i]) && (i!=figure)){
                    result = false;
                }
            }
        }
        if(getFieldOfFigure(activePlayer, figure).equals(matchField.getHomeFields()[activePlayer][figure]) && dieResult!=6){
            result = false;
        }
        if(figuresTraveled[activePlayer][figure]+dieResult > 44){
            result = false;
        }
        return result;
    }

    public boolean figureIsAtHome(int activePlayer, int figure){
        return getFieldOfFigure(activePlayer, figure).equals(matchField.getHomeFields()[activePlayer][figure]);
    }

    public boolean homeIsFull(int activePlayer){
        int counter = 0;
        for(int i=0; i<4; i++){
            if(figureIsAtHome(activePlayer, i)){
                counter++;
            }
        }
        return counter == 4;
    }

    public Field getFieldOfFigure(int activePlayer, int figure){
        int n = 0;
        int m = 0;
        for(int i=0; i<11; i++) {
            for (int j = 0; j < 11; j++) {
                if((matchField.getFigures()[activePlayer][figure].getTranslateX() == matchField.getFieldArray()[i][j].getTranslateX()+5) && (matchField.getFigures()[activePlayer][figure].getTranslateY() == matchField.getFieldArray()[i][j].getTranslateY()+5)){
                    n = i;
                    m = j;
                    break;
                }
            }
        }
        return matchField.getFieldArray()[n][m];
    }

    public int rollDice(){
        return (int)((Math.random()) * 6 + 1);
    }

    public void displayDieResult(){
        MyPane.getGameRoot().getChildren().remove(imageView);
        switch (dieResult) {
            case 1 -> {
                dice = new Image("design/dice/1_dot.png");
            }
            case 2 -> {
                dice = new Image("design/dice/2_dots.png");
            }
            case 3 -> {
                dice = new Image("design/dice/3_dots.png");
            }
            case 4 -> {
                dice = new Image("design/dice/4_dots.png");
            }
            case 5 -> {
                dice = new Image("design/dice/5_dots.png");
            }
            case 6 -> {
                dice = new Image("design/dice/6_dots.png");
            }
        }
        imageView = new ImageView(dice);
        imageView.setX(1026);
        imageView.setY(210);
        MyPane.getGameRoot().getChildren().add(imageView);
    }

    public void displayInfoSpace(){
        switch (activePlayer) {
            case 0 -> {
                activePlayerDisplay.setText("Blau ist am Zug!");
                activePlayerDisplay.setTextFill(Color.rgb(54,101,196));
            }
            case 1 -> {
                activePlayerDisplay.setText("Gelb ist am Zug!");
                activePlayerDisplay.setTextFill(Color.rgb(236,187,0));
            }
            case 2 -> {
                activePlayerDisplay.setText("Orange ist am Zug!");
                activePlayerDisplay.setTextFill(Color.rgb(240,112,25));
            }
            case 3 -> {
                activePlayerDisplay.setText("Grün ist am Zug!");
                activePlayerDisplay.setTextFill(Color.rgb(105,166,64));
            }
        }
    }

    public void generateInfoSpace(){
        activePlayerDisplay = new GameLabel("Blau ist am Zug!", 910, 30);
        activePlayerDisplay.setTextFill(Color.rgb(54,101,196));
        activePlayerDisplay.setStyle("-fx-background-color: rgb(228, 228, 228)");
        activePlayerDisplay.setFont(font);
        MyPane.getGameRoot().getChildren().add(activePlayerDisplay);
    }

    public void nextPlayer(){
        if(activePlayer<3){
            activePlayer++;
        }else {
            activePlayer=0;
        }
        rolledDice=0;
    }

}

public class MatchField {

    private Field[][] fieldArray= new Field[11][11];
    private Field[] travelFields = new Field[40];
    private Field[][] finishFields = new Field[4][4];
    private Field[][] homeFields = new Field[4][4];
    private Field[] startFields = new Field[4];

    private Figure[][] figures = new Figure[4][4];

    public Field[][] getFieldArray() {
        return fieldArray;
    }

    public Field[] getTravelFields() {
        return travelFields;
    }

    public Field[][] getFinishFields() {
        return finishFields;
    }

    public Field[][] getHomeFields() {
        return homeFields;
    }

    public Field[] getStartFields() {
        return startFields;
    }

    public Figure[][] getFigures() {
        return figures;
    }

    MatchField(){
        generateWholeField();
        assignTravelFields();
        assignFinishFields();
        assignHomeFields();
        assignStartFields();
        generatePlayers();
    }

    public void generateWholeField(){
        for(int x=0; x<11; x++){
            for(int y=0; y<11; y++){
                if((x==10 && y==0) || (x==9 && y==0) || (x==9 && y==1) || (x==10 && y==1) || (x==6 && y==0) || (x==5 && y==1) || (x==5 && y==2) || (x==5 && y==3) || (x==5 && y==4)){
                    PlayerOneField playerOneField = new PlayerOneField((x*70)+((x+1)*10), (y*70)+((y+1)*10));
                    fieldArray[x][y]=playerOneField;
                    MyPane.getGameRoot().getChildren().add(playerOneField);
                }else if((x==1 && y==0) || (x==0 && y==0) || (x==0 && y==1) || (x==1 && y==1) || (x==0 && y==4) || (x==1 && y==5) || (x==2 && y==5) || (x==3 && y==5) || (x==4 && y==5)){
                    PlayerTwoField playerTwoField = new PlayerTwoField((x*70)+((x+1)*10), (y*70)+((y+1)*10));
                    fieldArray[x][y]=playerTwoField;
                    MyPane.getGameRoot().getChildren().add(playerTwoField);
                }else if((x==1 && y==9) || (x==0 && y==9) || (x==0 && y==10) || (x==1 && y==10) || (x==4 && y==10) || (x==5 && y==9) || (x==5 && y==8) || (x==5 && y==7) || (x==5 && y==6)){
                    PlayerThreeField playerThreeField = new PlayerThreeField((x*70)+((x+1)*10), (y*70)+((y+1)*10));
                    fieldArray[x][y]=playerThreeField;
                    MyPane.getGameRoot().getChildren().add(playerThreeField);
                }else if((x==10 && y==9) || (x==9 && y==9) || (x==9 && y==10) || (x==10 && y==10) || (x==10 && y==6) || (x==9 && y==5) || (x==8 && y==5) || (x==7 && y==5) || (x==6 && y==5)){
                    PlayerFourField playerFourField = new PlayerFourField((x*70)+((x+1)*10), (y*70)+((y+1)*10));
                    fieldArray[x][y]=playerFourField;
                    MyPane.getGameRoot().getChildren().add(playerFourField);
                }else if((x==5 && y==0) || (x==4 && y==0) || (x==4 && y==1) || (x==4 && y==2) || (x==4 && y==3) || (x==4 && y==4) || (x==3 && y==4) || (x==2 && y==4) || (x==1 && y==4) || (x==0 && y==5) || (x==0 && y==6) || (x==1 && y==6) || (x==2 && y==6) || (x==3 && y==6) || (x==4 && y==6) || (x==4 && y==7) || (x==4 && y==8) || (x==4 && y==9) || (x==5 && y==10) || (x==6 && y==10) || (x==6 && y==9) || (x==6 && y==8) || (x==6 && y==7) || (x==6 && y==6) || (x==7 && y==6) || (x==8 && y==6) || (x==9 && y==6) || (x==10 && y==5) || (x==10 && y==4) || (x==9 && y==4) || (x==8 && y==4) || (x==7 && y==4) || (x==6 && y==4) || (x==6 && y==3) || (x==6 && y==2) || (x==6 && y==1)){
                    TravelField travelField = new TravelField((x*70)+((x+1)*10), (y*70)+((y+1)*10));
                    fieldArray[x][y]=travelField;
                    MyPane.getGameRoot().getChildren().add(travelField);
                }else {
                    TravelField travelField = new TravelField((x*70)+((x+1)*10), (y*70)+((y+1)*10));
                    fieldArray[x][y]=travelField;
                }
            }
        }
    }

    public void assignTravelFields(){
        travelFields[0]=fieldArray[6][0];
        travelFields[1]=fieldArray[6][1];
        travelFields[2]=fieldArray[6][2];
        travelFields[3]=fieldArray[6][3];
        travelFields[4]=fieldArray[6][4];
        travelFields[5]=fieldArray[7][4];
        travelFields[6]=fieldArray[8][4];
        travelFields[7]=fieldArray[9][4];
        travelFields[8]=fieldArray[10][4];
        travelFields[9]=fieldArray[10][5];
        travelFields[10]=fieldArray[10][6];
        travelFields[11]=fieldArray[9][6];
        travelFields[12]=fieldArray[8][6];
        travelFields[13]=fieldArray[7][6];
        travelFields[14]=fieldArray[6][6];
        travelFields[15]=fieldArray[6][7];
        travelFields[16]=fieldArray[6][8];
        travelFields[17]=fieldArray[6][9];
        travelFields[18]=fieldArray[6][10];
        travelFields[19]=fieldArray[5][10];
        travelFields[20]=fieldArray[4][10];
        travelFields[21]=fieldArray[4][9];
        travelFields[22]=fieldArray[4][8];
        travelFields[23]=fieldArray[4][7];
        travelFields[24]=fieldArray[4][6];
        travelFields[25]=fieldArray[3][6];
        travelFields[26]=fieldArray[2][6];
        travelFields[27]=fieldArray[1][6];
        travelFields[28]=fieldArray[0][6];
        travelFields[29]=fieldArray[0][5];
        travelFields[30]=fieldArray[0][4];
        travelFields[31]=fieldArray[1][4];
        travelFields[32]=fieldArray[2][4];
        travelFields[33]=fieldArray[3][4];
        travelFields[34]=fieldArray[4][4];
        travelFields[35]=fieldArray[4][3];
        travelFields[36]=fieldArray[4][2];
        travelFields[37]=fieldArray[4][1];
        travelFields[38]=fieldArray[4][0];
        travelFields[39]=fieldArray[5][0];
    }

    public void assignFinishFields(){
        finishFields[0][0]=fieldArray[5][1];
        finishFields[0][1]=fieldArray[5][2];
        finishFields[0][2]=fieldArray[5][3];
        finishFields[0][3]=fieldArray[5][4];
        finishFields[1][0]=fieldArray[1][5];
        finishFields[1][1]=fieldArray[2][5];
        finishFields[1][2]=fieldArray[3][5];
        finishFields[1][3]=fieldArray[4][5];
        finishFields[2][0]=fieldArray[5][9];
        finishFields[2][1]=fieldArray[5][8];
        finishFields[2][2]=fieldArray[5][7];
        finishFields[2][3]=fieldArray[5][6];
        finishFields[3][0]=fieldArray[9][5];
        finishFields[3][1]=fieldArray[8][5];
        finishFields[3][2]=fieldArray[7][5];
        finishFields[3][3]=fieldArray[6][5];
    }

    public void assignHomeFields(){
        homeFields[0][0]=fieldArray[10][0];
        homeFields[0][1]=fieldArray[9][0];
        homeFields[0][2]=fieldArray[9][1];
        homeFields[0][3]=fieldArray[10][1];
        homeFields[1][0]=fieldArray[1][0];
        homeFields[1][1]=fieldArray[0][0];
        homeFields[1][2]=fieldArray[0][1];
        homeFields[1][3]=fieldArray[1][1];
        homeFields[2][0]=fieldArray[1][9];
        homeFields[2][1]=fieldArray[0][9];
        homeFields[2][2]=fieldArray[0][10];
        homeFields[2][3]=fieldArray[1][10];
        homeFields[3][0]=fieldArray[10][9];
        homeFields[3][1]=fieldArray[9][9];
        homeFields[3][2]=fieldArray[9][10];
        homeFields[3][3]=fieldArray[10][10];
    }

    public void assignStartFields(){
        startFields[0] = fieldArray[6][0];
        startFields[1] = fieldArray[0][4];
        startFields[2] = fieldArray[4][10];
        startFields[3] = fieldArray[10][6];
    }

    public void generatePlayers(){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                switch (i) {
                    case 0 -> {
                        figures[i][j] = new PlayerOneFigure((int) homeFields[i][j].getTranslateX() + 5, (int) homeFields[i][j].getTranslateY() + 5);
                        MyPane.getGameRoot().getChildren().add(figures[i][j]);
                    }
                    case 1 -> {
                        figures[i][j] = new PlayerTwoFigure((int) homeFields[i][j].getTranslateX() + 5, (int) homeFields[i][j].getTranslateY() + 5);
                        MyPane.getGameRoot().getChildren().add(figures[i][j]);
                    }
                    case 2 -> {
                        figures[i][j] = new PlayerThreeFigure((int) homeFields[i][j].getTranslateX() + 5, (int) homeFields[i][j].getTranslateY() + 5);
                        MyPane.getGameRoot().getChildren().add(figures[i][j]);
                    }
                    case 3 -> {
                        figures[i][j] = new PlayerFourFigure((int) homeFields[i][j].getTranslateX() + 5, (int) homeFields[i][j].getTranslateY() + 5);
                        MyPane.getGameRoot().getChildren().add(figures[i][j]);
                    }
                }
            }
        }
    }
}

import java.awt.*;
import java.io.Serializable;

public class Gameboard implements Serializable {
    private int[][] board;
    private X drawerX;
    private O drawerO;
    public boolean gameState;
    public boolean turn;
    public int serverWins;
    public int clientWins;

    public Gameboard(){
        board = new int[3][3];
        drawerX = new X();
        drawerO = new O();
        gameState = false;
        turn = true;
        serverWins = 0;
        clientWins =0;
    }
    public void updateBoard(int piece, int mouseX,int mouseY){
        for(int i =0; i< board.length;i++){
            for(int j =0;j<board[i].length;j++){
                if(mouseX>100*j&&mouseX<100*(j+1)&&mouseY>100*i&&mouseY<100*(i+1)){
                    if(board[i][j]==0){
                        board[i][j] = piece;
                        turn = true;
                    }
                }
            }
        }
    }
    public void drawBoard(Graphics g){
        for(int x=0; x<4;x++){
            g.drawLine(0,100*x,300,100*x);
        }
        for(int y =0;y<4;y++){
            g.drawLine(100*y,0,100*y,300);
        }
        for(int i = 0; i < board.length;i++){
            for(int j =0; j < board[i].length; j++){
                switch(board[i][j]){
                    case 1:
                        g.setColor(Color.BLUE);
                        drawerX.draw(i,j,g);
                        break;
                    case 2:
                        g.setColor(Color.RED);
                        drawerO.draw(i,j,g);
                        break;
                }
            }
        }
    }
    private boolean boardFull(){
        int boardCheck = 0;
        for(int i =0; i< board.length;i++){
            for(int j =0; j<board[i].length;j++){
                if(board[i][j]!=0){
                    boardCheck += 1;
                }
            }
        }
        return boardCheck==9;
    }
    public boolean rowFull(int row){
        int rowCheck =0;
        for(int i =0;i<board[row].length;i++){
            if(board[row][i]!=0){
                rowCheck +=1;
            }
        }
        return rowCheck==3;
    }
    public boolean columnCheck(int column){
        int columnCheck =0;
        for(int j =0; j < board.length;j++){
            if(board[j][column]!=0){
                columnCheck+=1;
            }
        }
        return columnCheck==3;
    }
    public boolean diaCheck(int dir){
        int diaCheck =0;
        if(dir ==0){
            //top left
            if(board[0][0]!=0){
                diaCheck+=1;
            }if(board[1][1]!=0){
                diaCheck+=1;
            }if(board[2][2]!=0){
                diaCheck+=1;
            }
        }else if(dir ==1){
            //top right
            if(board[0][2]!=0){
                diaCheck+=1;
            }if(board[1][1]!=0){
                diaCheck+=1;
            }if(board[2][0]!=0){
                diaCheck+=1;
            }
        }
        return diaCheck==3;
    }
    public int checkGameCompletion() {
        int checkTotalAmount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int each : board[i]) {
                checkTotalAmount += each;
            }
            if (checkTotalAmount == 6&&columnCheck(i)) {
                return 1;
            } else if (checkTotalAmount == 3&&columnCheck(i)) {
                return 2;
            } else if (i == 2&&boardFull()) {
                return 0;
            }
            checkTotalAmount = 0;
        }
        for(int i = 0; i<board[0].length;i++){
            for(int j = 0; j<board.length;j++){
                checkTotalAmount += board[j][i];
            }
            if (checkTotalAmount == 6&&rowFull(i)) {
                return 1;
            } else if (checkTotalAmount == 3&&rowFull(i)) {
                return 2;
            }
            checkTotalAmount =0;
        }
        if(diaCheck(0)){
            checkTotalAmount += board[0][0];
            checkTotalAmount += board[1][1];
            checkTotalAmount += board[2][2];
            if(checkTotalAmount==3){
                return 2;
            }else if(checkTotalAmount==6){
                return 1;
            }
            checkTotalAmount =0;
        }
        if(diaCheck(1)){
            checkTotalAmount += board[0][2];
            checkTotalAmount += board[1][1];
            checkTotalAmount += board[2][0];
            if(checkTotalAmount==3){
                return 2;
            }else if(checkTotalAmount==6){
                return 1;
            }
        }
        return 3;
    }
    public void gameOver(int winner){
        switch (winner){
            case 0:
                System.out.println("Game Tied");
                break;
            case 1:
                System.out.println("Server Win");
                serverWins++;
                break;
            case 2:
                System.out.println("Client Win");
                clientWins++;
                break;
        }
        reset();
    }
    public void reset(){
        board = new int[3][3];
        gameState = false;
        turn = true;
    }

}

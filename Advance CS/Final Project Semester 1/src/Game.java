import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Game implements Serializable {
    private Map<Location<Integer,Integer>,BoardObject> gameBoard;
    private Player p1;
    private Player p2;
    public Game(){
        gameBoard= new HashMap<>();
        p1 = new Player();
        p2 = new Player();
        for(int i = 0; i < 11;i++){
            int randInt = ThreadLocalRandom.current().nextInt(1,9);
            int randInt2 = ThreadLocalRandom.current().nextInt(1,9);
            if(!gameBoard.containsKey(new Location<>(randInt,randInt2))){
                gameBoard.put(new Location<>(randInt,randInt2),new BoardObject(true,randInt,randInt2));
            } else{
                i--;
            }
        }
        for(int i =0; i<10;i++){
            int randInt = ThreadLocalRandom.current().nextInt(1,9);
            int randInt2 = ThreadLocalRandom.current().nextInt(1,9);
            if(!gameBoard.containsKey(new Location<>(randInt,randInt2))){
                gameBoard.put(new Location<>(randInt,randInt2),new BoardObject(false,randInt,randInt2));
            } else{
                i--;
            }
        }
    }
    public void drawGame(Graphics g){
        drawBoard(g);
        p1.drawPlayer(g);
        p2.drawPlayer(g);
        p1.drawItems(g);
        p2.drawItems(g);
        p1.drawHealth(g);
        p2.drawHealth(g);
    }

    private void drawBoard(Graphics g){
        for(int i = 0; i<8;i++){
            g.drawLine(100*i,0,100*i,800);
            g.drawLine(0,100*i,800,100*i);
        }
        for(int i = 1; i<8;i++){
            for(int j  =1;j<8;j++){
                if(gameBoard.containsKey(new Location<>(i,j))){
                    gameBoard.get(new Location<>(i,j)).drawObject(g);
                }
            }
        }
    }

    public void playerMove(boolean client, int direction){
        if(client&&direction==1){
            p1.moveUp();
        }
        if(client&&direction==2){
            p1.moveDown();
        }
        if(client&&direction==3){
            p1.moveLeft();
        }
        if(client&&direction==4){
            p1.moveRight();
        }
        if(!client&&direction==1){
            p1.moveUp();
        }
        if(!client&&direction==2){
            p1.moveDown();
        }
        if(!client&&direction==3){
            p1.moveLeft();
        }
        if(!client&&direction==4){
            p1.moveRight();
        }
    }

    public void playerLoseHealth(boolean client){
        if(client){
            p1.removeHealth();
        }else if(!client){
            p2.removeHealth();
        }
    }

    public void playerGainItem(boolean client,BoardObject item){
        if(client){
            p1.addItem(item);
        }else if(!client){
            p2.addItem(item);
        }
    }
}

import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
 
public class Game implements Serializable{
    public static final long serialVersionUID = 31;
    public boolean clientGot;
    private HashMap<Location,BoardObject> gameBoard;
    private Player p1;
    private Player p2;
    public boolean gameOver;
    private int winner;
    public Game(){
        gameOver = false;
        winner = 0;
        gameBoard= new HashMap<>();
        p1 = new Player(0);
        p2 = new Player(1);
        clientGot = false;
        for(int i = 0; i < 11;i++){
            int randInt = ThreadLocalRandom.current().nextInt(0,8);
            int randInt2 = ThreadLocalRandom.current().nextInt(0,8);
            if(randInt!=4&&randInt2!=4){
                Location temp = new Location(randInt,randInt2);
                if(!gameBoard.containsKey(temp)){
                    gameBoard.put(temp,new BoardObject(true,randInt,randInt2));
                } else{
                    i--;
                }
            }else{
                i--;
            }
        }
        for(int i = 0; i < 10;i++){
            int randInt = ThreadLocalRandom.current().nextInt(0,8);
            int randInt2 = ThreadLocalRandom.current().nextInt(0,8);
            if(randInt!=4&&randInt2!=4){
                Location temp = new Location(randInt,randInt2);
                if(!gameBoard.containsKey(temp)){
                    gameBoard.put(temp,new BoardObject(false,randInt,randInt2));
                } else{
                    i--;
                }
            }else{
                i--;
            }
        }
    }

    public void gameLogic(boolean client){
        if(!gameOver){
            if(client){
                Location temp = new Location(p1.getLocation()[0],p1.getLocation()[1]);
                if(gameBoard.containsKey(temp)){
                    if(gameBoard.get(temp).getObjectType()==0){
                        playerGainItem(client,gameBoard.get(temp));
                        gameBoard.remove(temp);
                    }else if(gameBoard.get(temp).getObjectType()==1){
                        playerLoseHealth(client);
                    }
                    if(p1.getItems()==6){
                        gameOver=true;
                        winner=1;
                    }
                    if(p1.getHealthSize()==0){
                        gameOver=true;
                        winner = 2;
                    }
                }
            } else if(!client){
                Location temp = new Location(p2.getLocation()[0],p2.getLocation()[1]);
                if(gameBoard.containsKey(temp)){
                    if(gameBoard.get(temp).getObjectType()==0){
                        playerGainItem(client,gameBoard.get(temp));
                        gameBoard.remove(temp);
                        // System.exit(0);
                    }else if(gameBoard.get(temp).getObjectType()==1){
                        playerLoseHealth(client);
                    }
                    if(p2.getItems()==6){
                        gameOver=true;
                        winner=2;
                    }
                    if(p2.getHealthSize()==0){
                        gameOver=true;
                        winner = 1;
                    }
                }
            }
        }
    }

    public void drawGame(Graphics g, boolean client){
        if(!gameOver){
            drawBoard(g);
            p1.drawPlayer(g);
            p2.drawPlayer(g);
            p1.drawItems(g);
            p2.drawItems(g);
            p1.drawHealth(g);
            p2.drawHealth(g);
        }else{
            drawOutcome(g,client);
        }
    }

    private void drawBoard(Graphics g){
        for(int i = 0; i<9;i++){
            g.drawLine(100*i,0,100*i,800);
            g.drawLine(0,100*i,800,100*i);
        }
        int x =0;
        for(int i = 0; i<8;i++){
            for(int j =0;j<8;j++){
                if(gameBoard.containsKey(new Location(i,j))){
                    gameBoard.get(new Location(i,j)).drawObject(g,0,0);
                }
            }
        }
    }

    public void playerMove(boolean client, int direction){
        if(!gameOver){
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
            p2.moveUp();
        }
        if(!client&&direction==2){
            p2.moveDown();
        }
        if(!client&&direction==3){
            p2.moveLeft();
        }
        if(!client&&direction==4){
            p2.moveRight();
        }
        if(client&&direction==5){
            gameBoard.put(new Location(p1.getLocation()[0],p1.getLocation()[1]), p1.useBomb(p1.getLocation()[0], p1.getLocation()[1]));
        }
        if(!client&&direction==5){
            gameBoard.put(new Location(p2.getLocation()[0],p2.getLocation()[1]), p2.useBomb(p2.getLocation()[0], p2.getLocation()[1]));
        }
        }
    }

    private void playerLoseHealth(boolean client){
        if(client){
            p1.removeHealth();
            p1.resetLocation();
            Sound.playSound("hit.wav");
        }else if(!client){
            p2.removeHealth();
            p2.resetLocation();
            Sound.playSound("hit.wav");
        }
    }

    private void playerGainItem(boolean client,BoardObject item){
        if(client){
            p1.addItem(item);
            Sound.playSound("coin.wav");
        }else if(!client){
            p2.addItem(item);
            Sound.playSound("coin.wav");
        }
    }

    public int getWinner(){
        return winner;
    }

    public void drawOutcome(Graphics g, boolean client){
        g.setColor(Color.WHITE);
        g.drawRect(0,0, 800, 800);
        g.setColor(Color.BLACK);
        if(winner == 1 && client){
            g.drawString("Winner", 400, 400);
        } else if(winner ==2 && client){
            g.drawString("Loser", 400, 400);
        }else if(winner ==1 && !client){
            g.drawString("Loser", 400, 400);
        }else if(winner ==2 && !client){
            g.drawString("Winner", 400, 400);
        }
    }

}

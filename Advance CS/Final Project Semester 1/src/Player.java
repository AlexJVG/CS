import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class Player implements Serializable {
    private Stack<Health> healthBar;
    private ArrayList<BoardObject> inventory;
    private int x;
    private int y;
    public Player(){
        healthBar = new Stack<>();
        for(int i=0; i< 5; i++){
            healthBar.push(new Health());
        }
        inventory = new ArrayList<>();
         x =4;
         y =4;
    }

    public void drawHealth(Graphics g){
        for(Health each : healthBar){
            each.drawHealth(g);
        }
    }

    public void drawItems(Graphics g){
        for(BoardObject each: inventory){
            each.drawObject(g);
        }
    }

    public void drawPlayer(Graphics g){

    }

    public void removeHealth(){
        healthBar.pop();
    }

    public void addItem(BoardObject item){
        inventory.add(item);
    }

    public void moveUp(){
        y++;
    }
    public void moveDown(){
        y--;
    }
    public void moveLeft(){
        x--;
    }
    public void moveRight(){
        x++;
    }
}

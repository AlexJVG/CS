import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class Player implements Serializable {
    public static final long serialVersionUID = 31;
    public int id;
    private Stack<Health> healthBar;
    private Stack<BoardObject> bombCount;
    private ArrayList<BoardObject> inventory;
    private int x;
    private int y;
    public Player(int id){
        this.id = id;
        healthBar = new Stack<>();
        bombCount = new Stack<>();
        for(int i=0; i< 5; i++){
            healthBar.push(new Health(i));
        }
        for(int i=0; i<5;i++){
            bombCount.push(new BoardObject(false,0,0));
        }
        inventory = new ArrayList<>();
        x =4;
        y =4;
    }

    public void drawHealth(Graphics g){
        for(Health each : healthBar){
            each.drawHealth(g,id);
        }
    }

    public void drawItems(Graphics g){
        for(int i = 0; i< inventory.size();i++){
            inventory.get(i).updateY(i/4);
            inventory.get(i).updateX(i%4);
            inventory.get(i).drawObject(g,1,id);
        }
    }

    public void drawPlayer(Graphics g){
        g.setColor(new Color(250,192,57));
        g.fillOval(36+x*100, 25+y*100, 25, 25);
        if(id==0){
            g.setColor(Color.blue);
        }else if(id==1){
            g.setColor(Color.red);
        }
        g.fillRect(36+x*100, 50+y*100, 25, 25);
        
        g.setColor(new Color(250,192,57));
        g.fillOval(800, 0+400*id, 25, 25);
        if(id==0){
            g.setColor(Color.blue);
        }else if(id==1){
            g.setColor(Color.red);
        }
        g.fillRect(800, 25+400*id, 25, 25);
    }

    public void removeHealth(){
        healthBar.pop();
    }

    public void addItem(BoardObject item){
        inventory.add(item);
    }

    public void moveUp(){
        if(y!=0){
            y--;
        }
    }
    public void moveDown(){
        if(y!=7){
            y++;
        }
    }
    public void moveLeft(){
        if(x!=0){
            x--;
        }
    }
    public void moveRight(){
        if(x!=7){
            x++;
        }
    }

    public int[] getLocation(){
        int[] array = new int[2];
        array[0] = x;
        array[1] = y;
        return array;
    }

    public void resetLocation(){
        x =4;
        y =4;
    }

    public int getId(){
        return this.id;
    }
    
    public BoardObject useBomb(int x, int y){
        BoardObject o = bombCount.pop();
        o.updateX(x);
        o.updateY(y);
        return o;
    }

    public int getHealthSize(){
        return healthBar.size();
    }

    public int getItems(){
        return inventory.size();
    }
}

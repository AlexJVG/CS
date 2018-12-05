import java.awt.*;
import java.io.Serializable;

public class BoardObject implements Serializable {
    public int objectType;
    private int x;
    private int y;
    public BoardObject(boolean item,int x,int y){
        if(item){
            objectType =0;
        }else{
            objectType =1;
        }
        this.x = x;
        this.y = y;
    }

    public void updateX(int x){this.x = x;}
    public void updateY(int y){this.y = y;}
    public void drawObject(Graphics g){
        if(objectType ==0){
            //draw item
        }
        else{
            //draw obstacle
        }
    }
}

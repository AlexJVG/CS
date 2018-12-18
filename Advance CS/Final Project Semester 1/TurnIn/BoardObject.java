import java.awt.*;
import java.io.Serializable;

public class BoardObject implements Serializable {
    public static final long serialVersionUID = 31;
    private int objectType;
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

    public int getObjectType(){
        return objectType;
    }
    public void updateX(int x){this.x = x;}
    public void updateY(int y){this.y = y;}
    public void drawObject(Graphics g,int when,int id){
        if(objectType ==0){
            g.setColor(Color.YELLOW);
            if(when==0){
                g.fillOval(x*100, y*100, 100, 100);
            }else if(when==1){
                g.fillOval(835+10*x, 25+10*y+400*id, 10, 10);
            }
        }
        else if(objectType==1){
            g.setColor(Color.RED);
            int[] z= new int[3];
            z[0] = 50+100*x;
            z[1] = 0+100*x;
            z[2] = 100+100*x;
            int[] f= new int[3];
            f[0] = 0+100*y;
            f[1] = 100+100*y;
            f[2] = 100+100*y;
            g.fillPolygon(z, f, 3);
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}

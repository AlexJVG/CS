import java.awt.*;
import java.io.Serializable;

public class Health implements Serializable {
    public static final long serialVersionUID = 31;
    private int x;
    public Health(int x){
        this.x = x;
    }
    public void drawHealth(Graphics g,int id){
        g.setColor(Color.BLACK);
        g.drawRect(835+10*x,10+400*id, 10, 10);
        g.setColor(Color.RED);
        g.fillRect(835+10*x,10+400*id, 10, 10);
    }
}

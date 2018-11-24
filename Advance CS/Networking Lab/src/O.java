import java.awt.*;
import java.io.Serializable;

public class O implements Serializable {
    public void draw(int row, int column, Graphics g){
        g.drawOval(100*column,100*row,100,100);
    }
}

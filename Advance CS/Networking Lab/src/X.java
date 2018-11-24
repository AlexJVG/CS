import java.awt.*;
import java.io.Serializable;

public class X implements Serializable {
    public void draw(int row, int column, Graphics g){
        g.drawLine(0+100*column,0+100*row,100+100*column,100+100*row);
        g.drawLine(100+100*column,0+100*row,0+100*column,100+100*row);
    }
}

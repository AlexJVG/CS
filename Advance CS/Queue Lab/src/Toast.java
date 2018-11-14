import javax.swing.*;
import java.awt.*;

public class Toast extends JFrame {
    private JWindow window;
    private JPanel panel;
    private JLabel toast;
    public Toast(String text){
        this.window = new JWindow();
        window.setBackground(new Color(0,0,0,0));
        this.toast = new JLabel("Text");
        this.panel = new JPanel(){
            public void paintComponent(Graphics g){
                int width = g.getFontMetrics().stringWidth(text);
                int height = g.getFontMetrics().getHeight();
                g.setColor(Color.black);
                g.fillRect(10, 10, width + 30, height + 10);
                g.setColor(Color.black);
                g.drawRect(10, 10, width + 30, height + 10);
                g.setColor(new Color(255, 255, 255, 240));
                g.drawString(text, 25, 27);
                int t = 250;
                for (int i = 0; i < 4; i++) {
                    t -= 60;
                    g.setColor(new Color(0, 0, 0, t));
                    g.drawRect(10 - i, 10 - i, width + 30 + i * 2,
                            height + 10 + i * 2);
                }
            }
        };
        window.add(toast);
        window.setLocation(0,0);
        window.setSize(800,100);
    }
    public void showToast(){
        try{
            window.setOpacity(1);
            window.setVisible(true);
            Thread.sleep(2000);
            for (double d = 1.0; d > 0.2; d -= 0.1) {
                Thread.sleep(100);
                window.setOpacity((float)d);
            }
            window.setVisible(false);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

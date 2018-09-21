import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Student {
    private String name;
    private String imageFile;
    private BufferedImage photoBuffer;

    public Student(String name, String imageFile) {
        this.name = name;
        this.imageFile = imageFile;
    }
    public void drawStudent(Graphics g, int x, int y) {
        try {
            File f = new File(imageFile);
            photoBuffer = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(photoBuffer, x, y, null);
    }

    public String toString() {
        return name;
    }
}
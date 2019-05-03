import javax.swing.JFrame;
import java.util.*;
import java.util.concurrent.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.*;
public class Runner{
	public static volatile CopyOnWriteArrayList<Long> list_enemy_id = new CopyOnWriteArrayList<>();
	public static volatile CopyOnWriteArrayList<Long> list_projectile_id = new CopyOnWriteArrayList<>();
	public static volatile ConcurrentHashMap<Long,Enemy> manager_enemy = new ConcurrentHashMap<>();
	public static volatile ConcurrentHashMap<Long,Projectile> manager_projectile = new ConcurrentHashMap<>();
	public static volatile ConcurrentHashMap<Long,Long> list_collisons = new ConcurrentHashMap<>();
	public static Image projectile_image;
	public static Image boss_projectile_image;
	public static Image enemy_image;
	public static Image boss_image;
	public static Image figher_image;
	public static void main(String[] args){
		try{
			projectile_image = ImageIO.read(new File("Projectile.png")).getScaledInstance(10, 10, Image.SCALE_DEFAULT);
			boss_projectile_image = ImageIO.read(new File("BossProjectile.png")).getScaledInstance(10, 10, Image.SCALE_DEFAULT);
			enemy_image = ImageIO.read(new File("enemy.png")).getScaledInstance(30, 30, Image.SCALE_DEFAULT);
			boss_image = ImageIO.read(new File("boss.png")).getScaledInstance(10, 10, Image.SCALE_DEFAULT);
			figher_image = ImageIO.read(new File("fighter.png")).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		}catch(Exception e ){
			System.out.println(e);
		}
		JFrame frame = new JFrame("RAFE'S BIG BOI ADVENTURE");
        Screen sc = new Screen();
        frame.add(sc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
}
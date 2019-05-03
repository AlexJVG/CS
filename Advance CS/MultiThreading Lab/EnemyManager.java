import java.util.Random;
import java.awt.*;
public class EnemyManager implements Runnable{
	public int enemy_killed;
	public EnemyManager(){
		this.enemy_killed =0;
	}
	public void run(){
		while(enemy_killed!=20){
			Enemy en = new Enemy(300,300);
			Thread t= new Thread(en);
			Runner.list_enemy_id.add(t.getId());
			Runner.manager_enemy.put(t.getId(),en);
			t.start();
			try{
				Thread.sleep(100);
			}catch(Exception e){
				System.out.println(e);
			}
 		}
	}
}
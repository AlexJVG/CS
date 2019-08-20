import java.util.Random;
import java.awt.*;
public class EnemyManager implements Runnable{
	public static int enemy_killed;
	public static boolean boss_killed;
	public static Boss boss;
	private BossManager bossMan;
	public EnemyManager(){
		this.enemy_killed =0;
		this.boss_killed = false;
	}
	public void run(){
		while(enemy_killed!=20){
			Enemy en = new Enemy(new Random().nextInt(7)*100+100,300);
			Thread t= new Thread(en);
			Runner.list_enemy_id.add(t.getId());
			Runner.manager_enemy.put(t.getId(),en);
			t.start();
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println(e);
			}
 		}
 		while(true){
 			if(Runner.list_enemy_id.size()==0){
 				break;
 			}
 		}
 		Screen.g.interrupt();
 		boss= new Boss();
 		Thread t = new Thread(boss);
 		t.start();
 		bossMan = new BossManager();
 		Thread f = new Thread(bossMan);
 		f.start();
 		while(!boss_killed){
 			boss.shoot();
 			try{
 				Thread.sleep(2000);
 			}catch(Exception e){}
 		}
	}
}
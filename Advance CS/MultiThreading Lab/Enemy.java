import java.awt.*;
public class Enemy implements Runnable{
	private int x,y;
	public Enemy(){
		this.x = 0;
		this.y=0;
	}
	public Enemy(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void run(){
		while(y<800){
			if(findCol(Thread.currentThread().getId())){
				break;
			}else{
				this.y=this.y+5;
				try{
					Thread.sleep(100);
				}catch(Exception e){}
			}
		}
		removeItem(Thread.currentThread().getId());
	}
	public void drawMe(Graphics g){
		g.drawImage(Runner.enemy_image,this.x,this.y,null);
	}
	private boolean findCol(long id){
		if(Runner.list_collisons.containsValue(id)){
			return true;
		}else{
			return false;
		}
	}
	public void removeItem(long id){
		Runner.list_enemy_id.remove(id);
		Runner.manager_enemy.remove(id);
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
}
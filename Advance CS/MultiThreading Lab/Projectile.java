import java.awt.*;
public class Projectile implements Runnable{
	private int x,y;
	public Projectile(int x,int y){
		this.x =x;
		this.y=y;
	}
	public void run(){
		while(y>0){
			if(findCol(Thread.currentThread().getId())||this.y==0){
				break;
			}else{
				this.y=this.y-20;
				try{
					Thread.sleep(100);
				}catch(Exception e){}
			}
		}
		removeItem(Thread.currentThread().getId());
	}
	public void drawMe(Graphics g){
		g.drawImage(Runner.projectile_image,this.x,this.y,null);
	}
	private boolean findCol(long id){
		if(Runner.list_collisons.containsKey(id)){
			return true;
		}else{
			return false;
		}
	}
	private void removeItem(long id){
		Runner.list_collisons.remove(id);
		Runner.list_projectile_id.remove(id);
		Runner.manager_projectile.remove(id);
	}
	public synchronized boolean col(Enemy en){
		if(en.getX()<this.x&&this.x<en.getX()+30&&en.getY()<this.y&&this.y<en.getY()+30){
			System.out.println("yqeet");
			return true;
		}else{
			return false;
		}
	}
}
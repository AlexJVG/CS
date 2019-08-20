import java.awt.*;
import java.util.*;
public class Fighter{
	private int x,y,lives;
	public Fighter(){
		this.x =0;
		this.y=0;
		this.lives = 3;
	}
	public Fighter(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void drawMe(Graphics g){
		g.drawImage(Runner.figher_image,this.x,this.y,null);
	}
	public void moveRight(){
		if(this.x<750){
			this.x+=10;
		}
	}
	public void moveUp(){
		if(this.y>0){
			this.y-=10;
		}
	}
	public void moveDown(){
		if(this.y<750){
			this.y+=10;
		}
	}
	public void moveLeft(){
		if(this.x>0){
			this.x-=10;
		}
	}
	public void shoot(){
		Projectile pro = new Projectile(this.x+20,this.y);
		Thread t= new Thread(pro);
		Runner.list_projectile_id.add(t.getId());
		Runner.manager_projectile.put(t.getId(),pro);
		t.start();
	}
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public void removeLife(){
		this.lives--;
	}
	public int getLives(){
		return this.lives;
	}
	public synchronized boolean col(BossProjectile bpro){
		if(bpro.getX()<this.x&&this.x<bpro.getX()+30&&bpro.getY()<this.y&&this.y<bpro.getY()+30){
			System.out.println("yqeet");
			return true;
		}else{
			return false;
		}
	}
}
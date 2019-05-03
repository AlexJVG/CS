import java.awt.*;
public class Drawer implements Runnable{
	private int x;
	private boolean dir;
	public Drawer(){
		this.x = 0;
		this.dir = false;
	}
	public void run(){
		while(true){
			if(x>=800){
				this.dir =true;
			}else if(x<=0){
				this.dir = false;
			}

			if(this.dir==false){
				this.x+=10;
			}else if(this.dir==true){
				this.x-=10;
			}
			try{
				Thread.sleep(100);
			}catch(Exception e){
				System.out.println();
			}
			System.out.println(this.x);
		}
	}
	public void drawMe(Graphics g){
		g.fillRect(this.x,400,200,200);
	}
}
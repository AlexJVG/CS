import java.util.Random;
public class RandomThingo{
	 public static Article getClass(int x, int y){
	 	Random rand = new Random();
		int n = rand.nextInt(3);
		n++;
		if(n==1){
			return new Dirt(x,y);
		}else if(n==2){
			return new Grass(x,y);
		}else if(n==3){
			return new Water(x,y);
		}
		return null;
	 }

	 public static Article getObject(int x,int y){
	 	Random rand = new Random();
		int n = rand.nextInt(3);
		n++;
		if(n==1){
			return new City(x,y);
		}else if(n==2){
			return new Tree(x,y);
		}else if(n==3){
			return new Boulder(x,y);
		}
		return null;
	 }
}
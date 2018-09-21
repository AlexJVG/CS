import java.util.*;
public class Runner{
	public static void main(String[] args){
		ArrayList<Animal> animalList= new ArrayList<Animal>();
		Scanner kb = new Scanner(System.in);
		for(int i =0;i<=2;i++){
			System.out.println("Enter the type of the animal and the age");
			animalList.add(new Animal(kb.next(),kb.nextInt()));
		}
		Iterator<Animal> it = animalList.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
}
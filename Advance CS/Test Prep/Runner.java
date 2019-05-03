public class Runner{
	public static void main(String[] args){
		Manager man = new Manager();
		man.printStateOfList();
		man.start();
		man.printStateOfList();
	}
}
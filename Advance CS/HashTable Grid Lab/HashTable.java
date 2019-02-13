public class HashTable<E extends Article>{
	private DLList<E>[] table;
	public HashTable(){
		table = new DLList[100];
		for(int i =0; i< table.length;i++){
			table[i] = new DLList<E>();
		}
	}
	public void add(E data){
		System.out.println("x: "+ data.getX()+" - y: "+ data.getY());
		System.out.println(data.hashCode());
		table[data.hashCode()%97].add(data);
	}
	public DLList<E> get(int x,int y){
		return table[(x+(101*y))%97];
	}
	public boolean remove(E data){
		for(int i =0;i<table.length;i++){
			if(table[i].remove(data)){
				return true;
			}
		}
		return false;
	}
	public void firstThingo(){
		table[0] = new DLList<E>();
	}
}

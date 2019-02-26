public class HashTable<E>{
	private DLList<E>[] table;
	@SuppressWarnings("unchecked")
	public HashTable(){
		table = new DLList[10000];
		for(int i =0;i<table.size();i++){
			table[i] = new DLList<E>();
		}
	}
	public void add(E data){
		table[data.hashCode()].add(data);
	}
	public void remove(E data){
	    for(int i=0;i<table.length;i++){
	      if(table[data.hashCode()].size()>0){
	        table[data.hashCode()] = new DLList<E>();
	      }
	    }
	}
	public 
}
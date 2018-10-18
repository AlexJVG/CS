import java.io.Serializable;

public class Item implements Comparable<Item>,Serializable{
	private static final long serialVersionUID = 1709232923693102051L;
	private String name;
	private double price;
	public Item(String name,double price) {
		this.price = price;
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object o) {
		Item t = (Item)o;
		if(name.equals(t.getName())&&price ==t.getPrice()) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		int hashCode =0;
		for(int i =0;i<name.length()-1;i++) {
			hashCode = 	hashCode + (int) (name.charAt(i)) * 17;
		}
		hashCode = (int) (hashCode*price);
		return hashCode;
		
	}
	@Override
	public int compareTo(Item t) {
		 if( name.equals( t.getName() ) && price == t.getPrice() )
	            return 0;
	        else if( name.compareTo(t.getName()) == 0 )
	            return (int) (price-t.getPrice());
	        else
	            return name.compareTo(t.getName());
	}
	@Override
    public String toString(){
        return name + ": $"+price+"\n";
    }
}

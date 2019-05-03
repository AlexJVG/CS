import java.util.ArrayList;
public class Order implements Comparable<Order>{
	private int order;
	private ArrayList<MenuItem> items;
	public Order(){
		this.items = new ArrayList<>();
		this.order = 0;
	}
	public void addItem(MenuItem item){
		this.items.add(item);
	}
	public ArrayList getItems(){
		return items;
	}
	public int getOrder(){
		return order;
	}
	public int getPrice(){
		int price = 0;
		for(MenuItem each : items){
			price +=each.getPrice();
		}
		return price;
	}
	public int compareTo(Order o){
		if(getOrder() > o.getOrder()){
			return 1;
		}else if(getOrder() < o.getOrder()){
			return -1;
		}else{
			return 0;
		}
	}
	public void setOrder(int order){
		this.order = order;
	}
}
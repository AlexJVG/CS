import java.util.*;

public class Item{
  private String name;
  private double price;
  private int quantity;
  private Date timeadded;

  public Item(String name,double price,int quantity, Date timeadded){
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.timeadded = timeadded;
  }

  public String toString(){
    return name+","+price+","+quantity+","+timeadded.getTime();
  }

  public void addItem(){
    quantity++;
  }

  public String getName(){
    return name;
  }

  public double getPrice(){
    return price;
  }

  public long getTime(){
    return timeadded.getTime();
  }

  public int getQuantity(){
    return quantity;
  }
  
  public boolean sameItem(String name,double price){
    if(this.name.equals(name)&&this.price==price){
      return true;
    }else{
      return false;
    }
  }
}

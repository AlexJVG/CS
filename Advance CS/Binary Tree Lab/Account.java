import java.io.Serializable;
public class Account implements Comparable<Account>,Serializable{
	private String first,last;
	private double bal;
	private int pin;
	private final static long serialVersionUID = 6529685098267757690L;
	public Account(String first,String last,int pin,double bal){
		this.pin = pin;
		this.bal = bal;
		this.first=first;
		this.last=last;
	}
	public String getFirst(){
		return this.first;
	}
	public String getLast(){
		return this.last;
	}
	public double getBal(){
		return this.bal;
	}
	public int getPin(){
		return this.pin;
	}
	public void setBal(double bal){
		this.bal = bal;
	}
	public void setPin(int pin){
		this.pin = pin;
	}
	public void setFirst(String first){
		this.first = first;
	}
	public void setLast(String last){
		this.last = last;
	}
	public String toString(){
		return this.first+","+this.last+"\n";
	}
	public String reverso(){
		return this.last+","+this.first+"\n";
	}
	public int compareTo(Account o){
		return reverso().compareTo(o.reverso());
	}
	public int hashCode(){
		return this.pin;
	}
	public boolean equals(Account o){
		if(this.first.equals(o.getFirst())&&this.last.equals(o.getLast())){
			return true;
		}else{
			return false;
			}
	}
}
import java.io.Serializable;
public class Country implements Serializable{
	private String abriviation,name;
	private int numberOfImages;
	public Country(String abriviation,String name,int numberOfImages){
		this.abriviation=abriviation;
		this.name=name;
		this.numberOfImages=numberOfImages;
	}
	public int hashCode(){
		return abriviation.substring(0).hashCode()*(abriviation.substring(1).hashCode()*257);
	}
	public String toString(){
		return name;
	}
	public String abv(){
		return abriviation;
	}
	public int numImg(){
		return numberOfImages;
	}
	public void upImg(){
		numberOfImages++;
	}
	public void downImg(){
		numberOfImages--;
	}
}
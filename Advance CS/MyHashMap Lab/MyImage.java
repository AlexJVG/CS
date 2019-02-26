import java.io.Serializable;
public class MyImage implements Serializable{
	private String url,caption,date;
	private final static long serialVersionUID = 6529685098267757690L;
	public MyImage(String url,String caption,String date){
		this.url = url;
		this.caption = caption;
		this.date = date;
	}
	public String url(){
		return url;
	}
	public String caption(){
		return caption;
	}
	public String date(){
		return date;
	}
	public String toString(){
		return url;
	}
	public boolean equals(MyImage other){
		if(this.url.equals(other.url())){
			return true;
		}
		return false;
	}
}
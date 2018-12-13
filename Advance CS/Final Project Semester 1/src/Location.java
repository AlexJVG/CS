import java.io.Serializable;

public class Location implements Serializable{
    public static final long serialVersionUID = 31;
    private int x;
    private int y;
    public Location(int x, int y){
        this.x = x;
        this.y =y;
    }

    @Override
    public int hashCode(){
        return 31*x+y;
    }

    @Override    
    public boolean equals(Object o){
        Location temp= (Location) o;
        if(temp.hashCode() == hashCode()){
            return true;
        }else{
            return false;
        }
    }
}
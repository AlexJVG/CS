public class Billed implements Comparable<Billed>{
    private String cheat;
    private String lastName;
    private String firstName;
    public Billed(String cheat,String lastName,String firstName){
        this.cheat = cheat;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    public String toString(){
        return cheat;
    }
    public int compareTo(Billed other){
        int d = this.lastName.compareTo(other.lastName);
        if (d == 0)
            d = this.firstName.compareTo(other.firstName);
        return d;
    }
}

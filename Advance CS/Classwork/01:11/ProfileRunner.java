import java.util.LinkedList;
import java.util.Scanner;

public class ProfileRunner{
  public static void main(String[] args){
    LinkedList<Profile> list = new LinkedList<Profile>();
    Scanner kb = new Scanner(System.in);
    list.add(new Profile("A",1));
    list.add(new Profile("B",2));
    list.add(new Profile("C",3));
    System.out.println(list);
    String input = kb.next();
    for(int i = 0; i<list.size();i++){
      if(list.get(i).equals(input)){
        list.remove(i);
        i--;
      }
    }
    System.out.println(list);
  }

}

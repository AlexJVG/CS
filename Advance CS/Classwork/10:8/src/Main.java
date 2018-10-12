import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		HashMap<Integer,String> studentList = new HashMap<Integer,String>();
	    studentList.put(1382,"Jeff");
	    studentList.put(1002,"James");
	    studentList.put(1002,"James");
	    studentList.put(9999,"John");
	    studentList.put(1111,"John");
	    studentList.put(1000,"Jess");
	    studentList.put(1000,"Jennifer");


	    Iterator<Integer> it;
	    it = studentList.keySet().iterator();
	    while(it.hasNext()){
	      int c = it.next();
	      System.out.println(c + " - " + studentList.get(c));
	    }

	    TreeMap<Character,Integer> charList = new TreeMap<Character,Integer>();
	    String data = "a b c d e f g h i a c d e g h i h k";
	    for(char c : data.toCharArray()){
	      if(charList.get(c)==null)
	          charList.put(c,0);
	      charList.put(c,charList.get(c)+1);
	    }
	    System.out.println(charList.get("a"));

	}

}

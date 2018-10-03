import java.util.*;
public class Main{
	public static void main(String[] args){
		String[] list = "4 4 4 4 4 4 4 4 ".split(" ");
		Set<Integer> tree = new TreeSet<Integer>();
		Set<Integer> unique = new TreeSet<Integer>();
		Set<Integer> duplicate = new TreeSet<Integer>();
		for(String each : list){
			if(tree.add(Integer.parseInt(each))&&Integer.parseInt(each)%2!=0){
				unique.add(Integer.parseInt(each));
			}
			else if(!tree.add(Integer.parseInt(each))&&Integer.parseInt(each)%2==0){
				duplicate.add(Integer.parseInt(each));
			}
		}
		System.out.println(unique);
		System.out.println(duplicate);
	}
}
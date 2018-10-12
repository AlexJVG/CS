import java.util.HashMap;

public class Warmup {

	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		int[] nums = {1,2,3,4,5,6,1,2,3,4,5,1,3,1,2,3,4};
		for(int each : nums) {
			if(map.containsKey(each)) {
				map.put(each,map.get(each)+"*");
			}else {
				map.put(each,"*");
			}
		}
		for(int each : map.keySet()) {
			System.out.println(each + "\t"+ map.get(each));
		}
	}

}

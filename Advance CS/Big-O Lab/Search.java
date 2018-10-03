import java.util.*;
public class Search{
	private int recursions;
	public Search(){
		recursions=0;
	}
	public int getRecursions(){
		return recursions;
	}
	public void setRecursions(){
		recursions=0;
	}
	public int binarySearch(ArrayList<Student> list,int start,int end, String value){ 
		if (start<=end) 
        { 
            int mid = (end+start)/2;
            System.out.println(mid);
       		System.out.println(list.get(mid).getLastName());
        	recursions++;
            if (list.get(mid).getLastName().compareTo(value)==0){
            	return mid+1;
            }  
            if (list.get(mid).getLastName().compareTo(value)<0) {
           		return binarySearch(list,mid+1, end, value); 
            }
            if (list.get(mid).getLastName().compareTo(value)>0) {	
                return binarySearch(list,start, mid-1, value); 
            } 
        } 
        return -1; 
	}
	public int sequentialSearch(ArrayList<Student> list,String value){
		for(int i = 0; i<list.size()-1;i++){
			recursions++;
			if(list.get(i).getLastName().equals(value)){
				return i+1;
			}
		}
		return -1;
	}
	public ArrayList<Student> scramble(ArrayList<Student> list){
		Random r = new Random();
		for (int i = list.size()-1; i > 0; i--) { 
            int j = r.nextInt(i);  
            Student temp = list.get(i); 
            list.set(i, list.get(j)); 
            list.set(j, temp); 
        } 
		return list;
	}
	public ArrayList<Student> mergeSort(ArrayList<Student> list,int l, int r){
		if (l < r) 
        { 
            int m = (l+r)/2; 
            mergeSort(list, l, m); 
            mergeSort(list , m+1, r); 
            list = merge(list, l, m, r); 
        }
		return list;
	}
	public ArrayList<Student> merge(ArrayList<Student> list, int l, int m, int r) {		
        int n1 = m - l + 1; 
        int n2 = r - m; 
        ArrayList<Student> L = new ArrayList<Student>(); 
        ArrayList<Student> R = new ArrayList<Student>(); 
        for (int i=0; i<n1; ++i) 
        	L.add(list.get(l+i));
        for (int j=0; j<n2; ++j) 
        	R.add(list.get(m + 1+ j));
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L.get(i).getLastName().compareTo(R.get(j).getLastName())<=0) 
            { 
                list.set(k, L.get(i)); 
                i++; 
            } 
            else
            { 
            	list.set(k, R.get(j));
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
            list.set(k, L.get(i)); 
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
        	list.set(k, R.get(j));  
            j++; 
            k++; 
        }
        recursions++;
		return list;
	}
	public ArrayList<Student> bubbleSort(ArrayList<Student> list,int n){
		int i,j;
		Student temp;
		boolean swapped;
		for (i = 0; i < n - 1; i++)  
        { 
            swapped = false; 
            for (j = 0; j < n - i - 1; j++)  
            { 
                if (list.get(j).getLastName().compareTo(list.get(j+1).getLastName())>0)  
                { 
                    temp = list.get(j); 
                    list.set(j, list.get(j+1)); 
                    list.set(j+1, temp); 
                    swapped = true; 
                } 
                recursions++;
            } 
            if (swapped == false) 
                break; 
        } 
		return list;
		
	}
}
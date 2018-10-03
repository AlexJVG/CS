import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    int[] array;
    Scanner kb = new Scanner(System.in);
    Search s1 = new Search();
    while(true){
    System.out.println("What is the size of the array?");
    int size = kb.nextInt();
    array = new int[size];
    for(int i = 0; i < array.length; i++){
      array[i] = (int)(Math.random()*size+1);
    }
    for(int i=0; i < array.length-1; i++ ){  
       for(int j=i+1; j < array.length; j++){
         if( array[j] < array[i] ){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
         }
       }
    }
    for(int i =0;i<array.length;i++){
      System.out.print(array[i]+", ");
    }
    System.out.println("What number do you want to search");
    int search = kb.nextInt();
    System.out.println(s1.binarySearch(array,search,0,array.length-1));
    }
  }
}
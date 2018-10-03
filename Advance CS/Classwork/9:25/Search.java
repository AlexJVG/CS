public class Search{
  private int recusiveNum;
  public Search(){
    recusiveNum =0;
  }
  public int binarySearch (int[] list, int value, int  start_pos, int end_pos){
    recusiveNum =0;
    if(start_pos<=end_pos){
      int mid = (start_pos+end_pos)/2;
      if(value==list[mid]){
        System.out.println("found");
        System.out.println(recusiveNum);
        return mid;
      }
      if(value<list[mid]){
        start_pos=start_pos;
        end_pos=mid-1;
        System.out.println("split");
        recusiveNum++;
        return binarySearch(list,value,start_pos,end_pos);
      }
      if(value>list[mid]){
        start_pos=mid+1;
        end_pos=end_pos;
        System.out.println("split");
        recusiveNum++;
        return binarySearch(list, value, start_pos, end_pos);
      }
    }
    return -1;
  }
}
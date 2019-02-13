public class HashTable{
  private DLList[] table;

 public HashTable(){
   table = new DLList[10];
   table[0] = new DLList();
    table[1] = new DLList();
    table[2] = new DLList();
    table[3] = new DLList();
    table[4] = new DLList();
    table[5] = new DLList();
    table[6] = new DLList();
    table[7] = new DLList();
    table[8] = new DLList();
    table[9] = new DLList();
 }

 public void add(Word data){
   table[data.getVowel()*data.getLetter()%10].add(data);
 }

 public String toString(){
   String returnString ="";
   for(int i=0;i<table.length;i++){
     returnString+="bucket "+ i+" - "+table[i].toString()+"\n";
   }
   return returnString;
 }
}
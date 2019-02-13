class Main {
  public static void main(String[] args) {
    String words ="one two dog cat chicken pig owl jump run hop shortcut ferret goat hootowl owl go alligator onimonapia food a";
    HashTable table = new HashTable();
    for(String each : words.split(" ")){
      table.add(new Word(each));
    }
    System.out.println(table);
  }
}
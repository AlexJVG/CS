import java.io.Serializable;
public class MyHashMap<K,V> implements Serializable{
  private DLList<V>[] table;
  private DLList<K> keyList;
  @SuppressWarnings("unchecked")
  public MyHashMap(){
    table = new DLList[255];
    keyList = new DLList<>();
    for(int i=0;i<table.length;i++){
      table[i] = new DLList<V>();
    }
  }
  public void put(K key, V value){
    if(!value.toString().equals("")){
      table[key.hashCode()%251].add(value);
      keyList.upImg(key);
    }
    if(!getKeys().findItem(key)){
      keyList.add(key);
    }
  }
  public DLList<V> get(K key){
    return table[key.hashCode()%251];
  }
  public DLList<K> getKeys(){
    return keyList;
  }
  public String toString(){
    String returnString = "";
    DLList<K> test = getKeys();
    for(int i =0;i<test.size();i++){
      returnString+="bucket "+test.get(i).hashCode()+" - "+test.get(i).toString()+" - ";
      DLList<V> test2 = get(test.get(i));
      for(int j =0;j<test2.size();j++){
        returnString+=test2.get(j)+", ";
      }
    }
    return returnString;
  }
  public void remove(K key, V value){
    get(key).remove(value);
    keyList.downImg(key);
  }
  public void remove(K key){
    for(int i=0;i<table.length;i++){
      if(table[key.hashCode()%251].size()>0){
        table[key.hashCode()%251] = new DLList<V>();
        keyList.remove(key);
      }
    }
  }
}
public class Profile{
  private String name;
  private int age;
  public Profile(String name, int age){
    this.name = name;
    this.age = age;
  }
  public String toString(){
    return name+":"+age;
  }
  public String getName(){
    return name;
  }
}

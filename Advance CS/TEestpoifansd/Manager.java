import java.util.ArrayList;
public class Manager{
  private ArrayList<ServerThread> man;
  private String totalText;
  public Manager(){
    man = new ArrayList<>();
    totalText = "";
  }
  public void broadcast(String msg){
    totalText = totalText + msg +"\n";
    for(ServerThread each : man){
      each.sendMSG(msg);
    }
  }
  public String upON(){
    return totalText;
  }
  public synchronized void add(ServerThread s){
    man.add(s);
  }
  public synchronized void remove(ServerThread s){
    man.remove(s);
  }
}

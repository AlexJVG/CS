public class Task implements Comparable<Task>{
  private String taskName;
  private int ranking;
  public Task(String taskName, int ranking){
    this.taskName = taskName;
    this.ranking = ranking;
  }
  public String getName(){
    return taskName;
  }
  public int getRanking(){
    return ranking;
  }
  public boolean equals(Object o){
    Task other = (Task) o;
    return this.taskName.equals(other.getName())&&this.ranking==other.getRanking();
  }
  public int compareTo(Task other){
    if(this.ranking==other.getRanking()){
        return this.taskName.compareTo(other.getName());
    }
    else if(this.ranking<other.getRanking()){
      return -1;
    }
    else if(this.ranking>other.getRanking()){
      return 1;
    }
    else{
      System.out.println("Error dubm");
      return 0;
    }
  }
  public String toString(){
    return taskName + " - "+ ranking+"\n";
  }
}
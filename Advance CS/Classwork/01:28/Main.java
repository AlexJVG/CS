import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    DLList<Task> TaskListManager = new DLList<Task>();
    TaskListManager.add(new Task("Alejandro cleaning", 1));
    TaskListManager.add(new Task("Ethan doing classwork", 1));
    TaskListManager.add(new Task("Alvin adding me as friend", 3));
    TaskListManager.add(new Task("Nerf Mercy", 1));
    TaskListManager.add(new Task("Rolling a 5stars", 2));
    while(true){
      System.out.println("1. Display task list by ranking and then sorted by name\n2. Add a task sorted by ranking order, and then by name.   You will need to use the compareTo method of the Comparable interface.  You cannot add a task with same name and rank.\n3. Remove task by name and rank.  Remove that task by name and rank.\n4. Update a task. Given a task name and rank by user, you can update the name and rank of that Task.\n5. Quit");
      int input = kb.nextInt();
      switch(input){
        case 1:
          System.out.println(TaskListManager);
          break;
        case 2:
          int ranking = kb.nextInt();
          String taskName = kb.next();
          TaskListManager.add(new Task(taskName,ranking));
          break;
        case 3:
          int ranking1 = kb.nextInt();
          String taskName1 = kb.next();
          TaskListManager.remove(new Task(taskName1,ranking1));
          break;
        case 4:
          int ranking2 = kb.nextInt();
          String taskName2 = kb.next();
          TaskListManager.update(new Task(taskName2,ranking2));
          break;
        case 5:
          System.exit(0);
      }
    }
  }
}
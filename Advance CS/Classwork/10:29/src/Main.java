import java.util.Stack;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
	Scanner kb = new Scanner(System.in);
    Stack<CellPhone> inventory= new Stack<CellPhone>();
    Stack<CellPhone> sold= new Stack<CellPhone>();
    while(true){
      System.out.println("What do you want to do?(1 for display inventory, 2 for display sold phone list, 3 for adding a phone, 4 for phone sale)");
      switch(kb.nextInt()){
        case 1:
        checkInventory(inventory);
        break;

        case 2:
        checkSold(sold);
        break;

        case 3:
        System.out.println("What is the phone number?");
        long number = kb.nextLong();
        System.out.println("What is the ID of the phone?");
        int id = kb.nextInt();
        addPhone(number, id,inventory);
        break;

        case 4:
        System.out.println("What is the date?(YYYYMMDD)");
        int date = kb.nextInt();
        phoneSale(inventory, sold, date);
        break;
      }
    }
    
  }

  public static void addPhone(long phoneNumber, int id,Stack<CellPhone> inventory){
    inventory.push(new CellPhone(phoneNumber,id));
  }

  public static void checkInventory(Stack<CellPhone> inventory){
    for(CellPhone each : inventory){
      System.out.println(each.toString());
    }
  }

  public static void checkSold(Stack<CellPhone> sold){
    for(CellPhone each : sold){
      System.out.println(each.toString());
    }
  }

  public static void phoneSale(Stack<CellPhone> inventory, Stack<CellPhone> sold, int date){
    long phoneNumber = inventory.peek().getPhoneNumber();
    int id = inventory.peek().getId();
    System.out.println(inventory.pop());
    sold.push(new CellPhone(phoneNumber,id,date));
  }
}
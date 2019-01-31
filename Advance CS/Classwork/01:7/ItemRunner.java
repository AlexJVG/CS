import java.util.LinkedList;

public class ItemRunner{
    public static void main(String[] args){
        LinkedList<Item> items = new LinkedList<>();
        items.add(new Item("Pencil",.25));
        items.add(new Item("Paper",.10));
        items.add(new Item("Pen",.49));
        System.out.println(items);
    }
}
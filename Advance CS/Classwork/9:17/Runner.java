import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
public class Runner {
    public static void main(String[] args) {
        String name;
        Scanner kb = new Scanner(System.in);
        ArrayList < Student > students = new ArrayList < Student > ();
        while (true) {
            System.out.println("Please enter a student's name and grade");
            students.add(new Student(kb.next(), kb.nextInt()));
            System.out.println("Do you want to enter another student? y or n");
            if (!kb.next().equals("y")) {
                break;
            }
        }
        Iterator < Student > it = students.iterator();
        while (true) {
            if (it.hasNext()) {
                System.out.println(it.next().toString());
            } else {
                System.out.println("If you wish to delete a student enter their name. If not type, exit");
                name = kb.next();
                if (name.equals("exit")) {
                    break;
                } else {
                    it = students.iterator();
                    if (students.size() == 1) {
                        it.next();
                        it.remove();
                    } else {
                        for (int i = 1; i < students.size(); i++) {
                            if (it.next().getName().equals(name)) {
                                it.remove();
                                break;
                            } else {
                                if (it.next().getName().equals(name)) {
                                    it.remove();
                                    break;
                                } else {
                                    System.out.println("Test: " + it.next().getName());
                                }
                            }
                        }
                        it = students.iterator();
                    }
                }
            }
        }
    }
}
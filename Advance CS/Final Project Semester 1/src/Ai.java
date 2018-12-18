import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import com.sun.media.sound.FFT;
import com.sun.tools.javac.code.Attribute.Array;

public class Ai extends Serializable {
    public static final long serialVersionUID = 31;
    public int id;
    private Stack<Health> healthBar;
    private ArrayList<BoardObject> inventory;
    private int x;
    private int y;

    public Ai() {
        this.id = 1;
        healthBar = new Stack<>();
        bombCount = new Stack<>();
        for (int i = 0; i < 5; i++) {
            healthBar.push(new Health(i));
        }
        inventory = new ArrayList<>();
        x = 4;
        y = 4;
    }

    private BoardObject nearestObject(HashMap<Location, BoardObject> gameBoard) {
        double nearest = 0;
        ArrayList<String> moveOrder= new ArrayList<String>();
        BoardObject test;
        for (Location each : gameBoard.keySet()) {
            if (gameBoard.get(each).getObjectType() == 0) {
                moveOrder.clear();
                int itemx = gameBoard.get(each).getX();
                int itemy = gameBoard.get(each).getY();
                int playerx = x;
                int playery = y;
                int moves = 0;
                while (playerx != itemx && playery != itemy) {
                    if (playerx < itemx && doesColide(gameBoard, playerx + 1, playery)) {
                        moveOrder.add("r");
                        playerx++;
                        moves++;
                    }
                    if (playerx > itemx && doesColide(gameBoard, playerx - 1, playery)) {
                        moveOrder.add("l");
                        playerx--;
                        moves++;
                    }
                    if (playery > itemy && doesColide(gameBoard, playerx, playery-1)) {
                        moveOrder.add("d");
                        playery--;
                        moves++;
                    }
                    if (playery < itemy && doesColide(gameBoard, playerx, playery+1)) {
                        moveOrder.add("u");
                        playery++;
                        moves++;
                    }
                }
                double testDistance = (itemy - playery) / (itemx - playerx) + moves;
                if (nearest > testDistance) {
                    nearest = testDistance;
                    test = gameBoard.get(each);
                }
            }
        }
        return new Vector<>();
    }

    private boolean doesColide(HashMap<Location, BoardObject> testBoard, int testx, int testy) {
        if (testBoard.get(new Location(testx, testy)).getObjectType() == 1) {
            return false;
        }
        return true;
    }
    
    private void moveAi(BoardObject getTo){

    }

    public void aiLogic(HashMap<Location,BoardObject> board) {
        BoardObject nearest = nearestObject(board);
        moveAi(nearest);
    }

    public void drawHealth(Graphics g) {
        for (Health each : healthBar) {
            each.drawHealth(g, id);
        }
    }

    public void drawItems(Graphics g) {
        for (int i = 0; i < inventory.size(); i++) {
            inventory.get(i).updateY(i / 4);
            inventory.get(i).updateX(i % 4);
            inventory.get(i).drawObject(g, 1, id);
        }
    }

    public void drawPlayer(Graphics g) {
        g.setColor(new Color(250, 192, 57));
        g.fillOval(36 + x * 100, 25 + y * 100, 25, 25);
        g.fillOval(800, 0 + 400 * id, 25, 25);
        g.setColor(Color.red);
        g.fillRect(36 + x * 100, 50 + y * 100, 25, 25);
        g.fillRect(800, 25 + 400 * id, 25, 25);
    }

    public void removeHealth() {
        healthBar.pop();
    }

    public void addItem(BoardObject item) {
        inventory.add(item);
    }

    public void moveUp() {
        if (y != 0) {
            y--;
        }
    }

    public void moveDown() {
        if (y != 7) {
            y++;
        }
    }

    public void moveLeft() {
        if (x != 0) {
            x--;
        }
    }

    public void moveRight() {
        if (x != 7) {
            x++;
        }
    }

    public int[] getLocation() {
        int[] array = new int[2];
        array[0] = x;
        array[1] = y;
        return array;
    }

    public void resetLocation() {
        x = 4;
        y = 4;
    }

    public int getId() {
        return this.id;
    }

    public int getHealthSize() {
        return healthBar.size();
    }

    public int getItems() {
        return inventory.size();
    }
}
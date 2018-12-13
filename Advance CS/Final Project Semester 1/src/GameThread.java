// import java.awt.*;
// import java.io.Serializable;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.concurrent.ThreadLocalRandom;
 
// public class Game extends Thread{
//     public void run(){
//         while(true){
//             gameLogic();
//         }
//     }
//     public static final long serialVersionUID = 31;
//     public boolean clientGot;
//     private Map<Integer,BoardObject> gameBoard;
//     private Player p1;
//     private Player p2;
//     public Game(){
//         gameBoard= new HashMap<>();
//         p1 = new Player(0);
//         p2 = new Player(1);
//         clientGot = false;
//         for(int i = 0; i < 11;i++){
//             int randInt = ThreadLocalRandom.current().nextInt(1,9);
//             int randInt2 = ThreadLocalRandom.current().nextInt(1,9);
//             if(!gameBoard.containsKey(randInt-randInt2)){
//                 gameBoard.put(randInt-randInt2,new BoardObject(true,randInt,randInt2));
//                 System.out.println(gameBoard.get(randInt-randInt2).getObjectType());
//             } else{
//                 i--;
//             }
//         }
//         System.out.println("test1 1");
//         // for(int i =0; i<10;i++){
//         //     int randInt = ThreadLocalRandom.current().nextInt(1,9);
//         //     int randInt2 = ThreadLocalRandom.current().nextInt(1,9);
//         //     if(!gameBoard.containsKey(randInt-randInt2)){
//         //         gameBoard.put(randInt-randInt2,new BoardObject(false,randInt,randInt2));
//         //     } else{
//         //         System.out.println("test z");
//         //         i--;
//         //     }
//         // }
//         // System.out.println("test1 2");
//     }

//     public void gameLogic(boolean client){
//         if(client){
//             for(int i = 1; i<8;i++){
//                 for(int j =1;j<8;j++){
//                     if(gameBoard.containsKey(i-j)&&gameBoard.containsKey(p1.getLocation()[0]-p1.getLocation()[1])){
//                         if(gameBoard.get(i-j).getObjectType()==0){
//                             playerGainItem(client, gameBoard.get(i-j));
//                             gameBoard.remove(i-j);
//                         }else if(gameBoard.get(i-j).getObjectType()==1){
//                             playerLoseHealth(client);
//                         }
//                     }
//                 }
//             }
//         } else if(!client){
//             for(int i = 1; i<8;i++){
//                 for(int j =1;j<8;j++){
//                     if(gameBoard.containsKey(p2.getLocation()[1]-p2.getLocation()[0])){
//                         if(gameBoard.get(p2.getLocation()[1]-p2.getLocation()[0]).getObjectType()==0){
//                             System.out.println("testaskjdfhasjdhfkajsdhfkjashkj");
//                             playerGainItem(client, gameBoard.get(p2.getLocation()[1]-p2.getLocation()[0]));
//                             gameBoard.remove(p2.getLocation()[1]-p2.getLocation()[0]);
//                         }else if(gameBoard.get(p2.getLocation()[1]-p2.getLocation()[0]).getObjectType()==1){
//                             playerLoseHealth(client);
//                         }
//                     }
//                 }
//             }
//         }
//     }

//     public void drawGame(Graphics g){
//         drawBoard(g);
//         p1.drawPlayer(g);
//         p2.drawPlayer(g);
//         p1.drawItems(g);
//         p2.drawItems(g);
//         p1.drawHealth(g);
//         p2.drawHealth(g);
//     }

//     private void drawBoard(Graphics g){
//         for(int i = 0; i<8;i++){
//             g.drawLine(100*i,0,100*i,800);
//             g.drawLine(0,100*i,800,100*i);
//         }
//         for(int i = 1; i<8;i++){
//             for(int j =1;j<8;j++){
//                 if(gameBoard.containsKey(i-j)){
//                     gameBoard.get(i-j).drawObject(g);
//                 }
//             }
//         }
//     }

//     public void playerMove(boolean client, int direction){
//         System.out.println("test");
//         if(client&&direction==1){
//             p1.moveUp();
//         }
//         if(client&&direction==2){
//             p1.moveDown();
//         }
//         if(client&&direction==3){
//             p1.moveLeft();
//         }
//         if(client&&direction==4){
//             p1.moveRight();
//         }
//         if(!client&&direction==1){
//             p2.moveUp();
//         }
//         if(!client&&direction==2){
//             p2.moveDown();
//         }
//         if(!client&&direction==3){
//             p2.moveLeft();
//         }
//         if(!client&&direction==4){
//             System.out.println("aisdjfosij");
//             p2.moveRight();
//         }
//     }

//     private void playerLoseHealth(boolean client){
//         if(client){
//             p1.removeHealth();
//             p1.resetLocation();
//         }else if(!client){
//             p2.removeHealth();
//             p2.resetLocation();
//         }
//     }

//     private void playerGainItem(boolean client,BoardObject item){
//         if(client){
//             p1.addItem(item);
//         }else if(!client){
//             p2.addItem(item);
//         }
//     }

//     public void updateObject(Object o){
//         SendObject received = (SendObject) o;
        
//     }
// }

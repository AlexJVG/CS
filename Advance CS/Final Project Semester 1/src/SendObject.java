// public class SendObject implements Serializable{
//     public boolean clientGot;
//     private Map<Integer,BoardObject> gameBoard;
//     private Player p1;
//     private Player p2;
//     public SendObject(boolean clientGot){
//         this.clientGot = clientGot;
//     }
//     public SendObject(Map<Integer,BoardObject> gameBoard){
//         this.gameBoard = gameBoard;
//     }
//     public SendObject(Player p){
//         if(p.getId()==0){
//             this.p1 = p;
//         }else if(p.getId()==1){
//             this.p2 = p;
//         }

//     }
//     public SendObject(Player p1, Player p2){
//         this.p1 = p1;
//         this.p2 = p2;
//     }
    
// }
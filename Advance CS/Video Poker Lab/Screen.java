import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Screen extends JPanel implements ActionListener,MouseListener{
	private DLList<Card> deck = new DLList<>();
	private DLList<Card> player = new DLList<>();
	private DLList<String> cardName = new DLList<>();
	private DLList<String> suitName = new DLList<>();
	private int playerPoints = 50;
	private JButton gameButton = new JButton("Start Game");
	private boolean gameStarted = false;
	private boolean cardsChanged = false;
	private JLabel playerPoint = new JLabel("Points: "+playerPoints);
	private int pointWon = 0;
	private JLabel pointsWon = new JLabel("Points Won: "+pointWon);
	public Screen(){
		this.setLayout(null);
		cardName.add("2");
		cardName.add("3");
		cardName.add("4");
		cardName.add("5");
		cardName.add("6");
		cardName.add("7");
		cardName.add("8");
		cardName.add("9");
		cardName.add("10");
		cardName.add("J");
		cardName.add("Q");
		cardName.add("K");
		cardName.add("A");
		suitName.add("club");
		suitName.add("diamond");
		suitName.add("heart");
		suitName.add("spade");
		gameButton.setBounds(0,0,200,200);
		gameButton.addActionListener(this);
		this.add(gameButton);
		playerPoint.setBounds(800,500,200,100);
		playerPoint.setFont(new Font("Arial", Font.PLAIN, 30));
		playerPoint.setVisible(false);
		this.add(playerPoint);
		pointsWon.setBounds(300,200,200,100);
		pointsWon.setFont(new Font("Arial", Font.PLAIN, 30));
		pointsWon.setVisible(false);
		this.add(pointsWon);
		addMouseListener(this);
		this.setFocusable(true);
	}
	public Dimension getPreferredSize() {
        return new Dimension(1000, 800);
    }
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.setColor(Color.green);
        g.fillRect(0, 0, 1500, 800);
        if(gameStarted){
        	for(int i =0;i<5;i++){
				player.get(i).drawMe(g,i);
			}
        }
    }
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==gameButton){
    		 if(gameButton.getText().equals("Start Game")){
    		 	gameStarted = true;
    		 	playerPoint.setVisible(true);
    		 	gameButton.setText("Draw");
    		 	gameButton.setBounds(800,600,200,200);
    		 	playerPoints--;
    		 }else if(gameButton.getText().equals("Draw")){
    		 	changeCards();
    		 	cardsChanged = true;
    		 	repaint();
    		 	checkWin();
    		 	gameButton.setText("Replay");
    		 }else if(gameButton.getText().equals("Replay")){
    		 	if(playerPoints>0){
    		 		shuffle();
    		 		pointsWon.setVisible(false);
	    		 	cardsChanged = false;
	    		 	playerPoints--;
	    		 	gameButton.setText("Draw");
    		 	}else{
    		 		System.exit(0);
    		 	}
    		 }
    	}
    	playerPoint.setText("Points: "+playerPoints);
    	repaint();
    }
    public void checkWin(){
    	int oldPoints = playerPoints;
    	for(int i =0; i<player.size();i++){
    		for(int j = i+1; j<player.size(); j++){
    			Card a = player.get(i);
    			Card b = player.get(j);
    			int aint = 0;
    			int bint = 0;
    			if(a.getName().equals("A")){
    				aint = 14;
    			}else if(a.getName().equals("K")){
    				aint = 13;
    			}else if(a.getName().equals("Q")){
    				aint = 12;
    			}else if(a.getName().equals("J")){
    				aint = 11;
    			}else{
    				aint = Integer.parseInt(a.getName());
    			}
    			if(b.getName().equals("A")){
    				bint = 14;
    			}else if(b.getName().equals("K")){
    				bint = 13;
    			}else if(b.getName().equals("Q")){
    				bint = 12;
    			}else if(b.getName().equals("J")){
    				bint = 11;
    			}else{
    				bint = Integer.parseInt(b.getName());
    			}
    			if(aint>bint){
    				player.set(i,b);
    				player.set(j,a);
    			}
    		}
    	}
    	boolean straight = false;
    	for(int i=0;i<5;i++){
    		Card a = player.get(i);
    		Card b = player.get(i+1);
    		int aint = 0;
			int bint = 0;
			if(a.getName().equals("A")){
				aint = 14;
			}else if(a.getName().equals("K")){
				aint = 13;
			}else if(a.getName().equals("Q")){
				aint = 12;
			}else if(a.getName().equals("J")){
				aint = 11;
			}else{
				aint = Integer.parseInt(a.getName());
			}
			if(b.getName().equals("A")){
				bint = 14;
			}else if(b.getName().equals("K")){
				bint = 13;
			}else if(b.getName().equals("Q")){
				bint = 12;
			}else if(b.getName().equals("J")){
				bint = 11;
			}else{
				bint = Integer.parseInt(b.getName());
			}
    		if(bint-aint!=1&&!(player.get(i+1).getName().equals("A")&&player.get(0).getName().equals("2"))){
    			break;
    		}
    		if(i==3){
    			straight = true;
    			break;
    		}
    	}
    	boolean flush = false;
    	int hearts =0;
    	int clubs =0;
    	int spades =0;
    	int diamonds = 0;
    	for(int i =0;i<5;i++){
    		if(player.get(i).getSuit().equals("heart")){
    			hearts++;
    		}
    		if(player.get(i).getSuit().equals("club")){
    			clubs++;
    		}
    		if(player.get(i).getSuit().equals("spade")){
    			spades++;
    		}
    		if(player.get(i).getSuit().equals("diamond")){
    			diamonds++;
    		}
    	}
    	if(hearts==5||clubs==5||spades==5||diamonds==5){
    		flush = true;
    	}
    	if(flush&&straight){
			if(player.get(0).getName().equals("10")){
				if(player.get(1).getName().equals("J")){
					if(player.get(2).getName().equals("Q")){
						if(player.get(3).getName().equals("K")){
							if(player.get(4).getName().equals("A")){
								//Royal Flush
								playerPoints+=250;
								pointWon = 250;
							}
						}
					}
				}
			}else{
				//Straight Flush
				playerPoints+=50;
				pointWon = 50;
			}
    	}else{
    		DLList<Integer> kindType = new DLList<>();
    		DLList<Pair<Integer,Integer>> typeAmount =new DLList<>();
			for(int i =0; i< 5;i++){
				int aint = 0;
				if(player.get(i).getName().equals("A")){
					aint = 14;
				}else if(player.get(i).getName().equals("K")){
					aint = 13;
				}else if(player.get(i).getName().equals("Q")){
					aint = 12;
				}else if(player.get(i).getName().equals("J")){
					aint = 11;
				}else{
					aint = Integer.parseInt(player.get(i).getName());
				}
				kindType.add(aint);
			}
			for (int j=0;j<kindType.size();j++){
				for (int k=j+1;k<kindType.size();k++){
					if (k!=j && kindType.get(k) == kindType.get(j)){
						if(typeAmount.get(kindType.get(j))==null){
							typeAmount.add(new Pair(kindType.get(j),1));
						}else{
							// typeAmount.put(kindType[j],typeAmount.get(kindType[j])+1);
							typeAmount.get(j).setValue(typeAmount.get(j).getValue()+1);
						}
					}
				}
			}
			if(typeAmount.containsValue(6)){
				//4 of a Kind
				playerPoints+=25;
				pointWon = 25;
			}else if(typeAmount.containsValue(3)&&typeAmount.containsValue(1)){
				//Full House
				playerPoints+=9;
				pointWon = 9;
			}else if(flush){
    			//Flush
    			playerPoints+=6;
    			pointWon = 6;
    		}else if(straight){
    			//Straight
    			playerPoints+=4;
    			pointWon = 4;
    		}else if(typeAmount.containsValue(3)){
				//3 of a Kind
				playerPoints+=3;
				pointWon = 3;
			}else if(typeAmount.containsValue(1)){
				boolean jackUp = false;
				for(int i =0; i< typeAmount.size();i++){
					if(typeAmount.get(i).getValue()==1){
						if(typeAmount.get(i).getKey()>=11){
							jackUp= true;
						}
						typeAmount.remove(i);
						break;
					}
				}
				if(typeAmount.containsValue(1)){
					//Two pair
					playerPoints+=2;
					pointWon = 2;
				}else{
    				//Pair
    				if(jackUp){
    					playerPoints+=1;
    					pointWon = 1;
    				}
				}
			}
    	}
    	if(oldPoints<playerPoints){
    		Sound.playSound("./win.mp3");
    		pointsWon.setText("Points Won: "+ pointWon);
    		pointsWon.setVisible(true);
    	}else{
    		System.out.println("asdf");
    		Sound.playSound("./lose.mp3");
    	}
    }
    public void mousePressed(MouseEvent e) {
    	if(!cardsChanged){
			for(int i =0;i<5;i++){
	    		player.get(i).cardClicked(i,e.getX(),e.getY());
	    	}
    	}
    	repaint();
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
	public void drawDeck(){
		for(int i = 0; i<suitName.size();i++){
			for(int j = 0; j<cardName.size();j++){
				deck.add(new Card(cardName.get(j),suitName.get(i)));
			}
		}
		shuffle();
	}
	public void shuffle(){
		if(cardsChanged){
			for(int j =0;j<5;j++){
				deck.add(player.get(j));
				player.remove(j);
			}
		}
		for(int i =0;i<7;i++){
			for(int j = deck.size();j>0;j--){
				int index = (int)(Math.random()*j+1);
				Card one = deck.get(index);
				Card two = deck.get(j);
				deck.set(index,two);
				deck.set(j,one);
			}
		}
		for(int j =0;j<5;j++){
			player.add(deck.get(j));
			deck.remove(j);
		}
	}
	public void changeCards(){
		for(int i =0;i<5;i++){
			if(!player.get(i).getKeep()){
				deck.add(player.get(i));
				player.remove(i);
				player.add(i,deck.get(0));
				deck.remove(0);
			}
			player.get(i).resetCards();
		}
	}
}
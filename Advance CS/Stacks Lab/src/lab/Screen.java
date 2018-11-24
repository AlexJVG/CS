import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Screen extends JPanel implements ActionListener, MouseListener{
	private static final long serialVersionUID = 6780488781747626496L;
	Square[][] grid;
	Stack<Square[][]> undoStack;
	Stack<Square[][]> redoStack;
	JButton undoButton;
	JButton redoButton;
	JButton clearButton;
	JButton redButton;
	JButton blueButton;
	JButton greenButton;
	JButton yellowButton;
	JButton orangeButton;
	JButton pinkButton;
	JButton purpleButton;
	JButton blackButton;
	JButton whiteButton;
	int currentR;
	int currentG;
	int currentB;
	
	int testvar =0;
	
	
	public Screen() {
		currentR = 0;
		currentG = 0;
		currentB = 0;
		addMouseListener(this);
		this.setLayout(null);
		grid = new Square[16][16];
		for(int r =0; r <grid.length;r++) {
			for(int c =0; c<grid[r].length;c++) {
				grid[r][c] = new Square(255,255,255);
			}
		}
		undoStack = new Stack<Square[][]>();
		undoStack.push(grid);
		redoStack = new Stack<Square[][]>();
		undoButton = new JButton("Undo");
		undoButton.setBounds(0,0,100,30);
		undoButton.addActionListener(this);
		this.add(undoButton);
		redoButton = new JButton("Redo");
		redoButton.setBounds(100, 0,100, 30);
		redoButton.addActionListener(this);
		this.add(redoButton);
		clearButton = new JButton("Clear");
		clearButton.setBounds(0,30,100,30);
		clearButton.addActionListener(this);
		this.add(clearButton);
		redButton = new JButton("Red");
		redButton.setBounds(0,60,100,30);
		redButton.addActionListener(this);
		this.add(redButton);
		blueButton = new JButton("Blue");
		blueButton.setBounds(0,90,100,30);
		blueButton.addActionListener(this);
		this.add(blueButton);
		greenButton = new JButton("Green");
		greenButton.setBounds(0,120,100,30);
		greenButton.addActionListener(this);
		this.add(greenButton);
		yellowButton = new JButton("Yellow");
		yellowButton.setBounds(0,150,100,30);
		yellowButton.addActionListener(this);
		this.add(yellowButton);	
		orangeButton = new JButton("Orange");
		orangeButton.setBounds(0,180,100,30);
		orangeButton.addActionListener(this);
		this.add(orangeButton);	
		pinkButton = new JButton("Pink");
		pinkButton.setBounds(0,210,100,30);
		pinkButton.addActionListener(this);
		this.add(pinkButton);
		purpleButton = new JButton("Purple");
		purpleButton.setBounds(0,240,100,30);
		purpleButton.addActionListener(this);
		this.add(purpleButton);
		whiteButton = new JButton("White");
		whiteButton.setBounds(0,270,100,30);
		whiteButton.addActionListener(this);
		this.add(whiteButton);
		blackButton = new JButton("Black");
		blackButton.setBounds(0,300,100,30);
		blackButton.addActionListener(this);
		this.add(blackButton);
		this.setFocusable(true);
	}
	public Dimension getPreferredSize() {
		return new Dimension(800,800);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println(testvar);
		for(int r =0;r<grid.length;r++) {
			for(int c =0; c<grid[r].length;c++) {
				grid[r][c].drawMe(200+20*c,0+20*r, g);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==undoButton) {
				if(undoStack.size()>0&&undoStack.empty()) {
					undoStack.pop();
					System.out.println("Size:"+undoStack.size());
					testvar++;
					grid = undoStack.peek();
					revalidate();
					repaint();
				}
		}
		else if(e.getSource()==redoButton) {
			if(redoStack.empty()) {
				undoStack.push(redoStack.pop());
				grid = undoStack.peek();
				revalidate();
				repaint();
			}
		}
		else if(e.getSource()==redButton) {
			currentR = 255;
			currentG = 0;
			currentB = 0;
		}
		else if(e.getSource()==blueButton) {
			currentR = 0;
			currentG = 0;
			currentB = 255;			
		}
		else if(e.getSource()==greenButton) {
			currentR = 0;
			currentG = 255;
			currentB = 0;
		}
		else if(e.getSource()==yellowButton) {
			currentR = 255;
			currentG = 255;
			currentB = 0;
		}
		else if(e.getSource()==orangeButton) {
			currentR = 255;
			currentG = 127;
			currentB = 0;
		}
		else if(e.getSource()==pinkButton) {
			currentR = 255;
			currentG = 0;
			currentB = 255;
		}
		else if(e.getSource()==purpleButton) {
			currentR = 127;
			currentG = 0;
			currentB = 255;
		}
		else if(e.getSource()==whiteButton) {
			currentR = 255;
			currentG = 255;
			currentB = 255;
		}
		else if(e.getSource()==blackButton) {
			currentR = 0;
			currentG = 0;
			currentB = 0;
		}
		else if(e.getSource()==clearButton) {
			Square[][] nsquare = new Square[16][16];
			for(int r =0; r <nsquare.length;r++) {
				for(int c =0; c<nsquare[r].length;c++) {
					nsquare[r][c] = new Square(255,255,255);
				}
			}
			undoStack.push(nsquare);
		}
		revalidate();
		repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int r =0; r< grid.length;r++){
			for(int c =0; c< grid[r].length;c++) {
				if(e.getX()>200+20*c &&e.getX()<200+20*c+20 &&e.getY()>0+20*r &&e.getY()<0+20*r+20) {
					grid[r][c].changeColor(currentR, currentG, currentB);
					Square[][] newSquare = new Square[16][16];
					for(int i = 0; i< grid.length; i++) {
						for(int j =0; j<grid[i].length;j++) {
							newSquare[i][j] = new Square(grid[i][j].getR(),grid[i][j].getG(),grid[i][j].getB());
						}
					}
					System.out.println(undoStack.push(newSquare));
					grid = undoStack.peek();
					revalidate();
					repaint();
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}

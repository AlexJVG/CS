import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Screen extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5595862134562500253L;
	Stack<String> stack = new Stack<String>();
	ArrayList<String> openingSymbols = new ArrayList<String>();
	ArrayList<String> closingSymbols = new ArrayList<String>();
	JTextField input = new JTextField();
	JLabel show = new JLabel();
	JButton click = new JButton("Check");
	public Screen() {
		openingSymbols.add("{");
		openingSymbols.add("(");
		openingSymbols.add("<");
		openingSymbols.add("[");
		click.addActionListener(this);
		closingSymbols.add("}");
		closingSymbols.add(")");
		closingSymbols.add(">");
		closingSymbols.add("]");
		this.add(input);
		this.add(show);
		this.add(click);
		this.setFocusable(true);
	}
	public Dimension getPreferredSize() {
		return new Dimension(800,800);
	}
	public void paintComponent(Graphics G) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==click) {
				String[] temp = input.getText().split("");
				for (int i = 0; i < temp.length; i++) {

					// check opening symbols
					for (int z = 0; z < openingSymbols.size(); z++) {
						if (openingSymbols.get(z).equals(temp[i])) {
							stack.push(temp[i]);
						}
					}

					// check closing symbols
					for (int z = 0; z < closingSymbols.size(); z++) {
						if (stack.empty() && closingSymbols.get(z).equals(temp[i]))
							stack.push(closingSymbols.get(z));

						else if (closingSymbols.get(z).equals(temp[i]) && openingSymbols.get(z).equals(stack.peek())) {
							stack.pop();
						}
					}
				}

				if (stack.empty()) {
					show.setText(input.getText() + " is correct");
				} else {

					while (!stack.empty()) {
						stack.pop();
					}
					show.setText(input.getText() + " is incorrect");
				}

			}
			repaint();
		}
}

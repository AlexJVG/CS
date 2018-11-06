import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class Screen extends JPanel implements ActionListener{
	JTextField text;
	JButton button;
	Stack<String> s;
	
	public Screen() {
		this.setLayout(null);
		s = new Stack<String>();
		text = new JTextField();
		text.setBounds(0,0,100,30);
		text.getDocument().addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e) 
            {
            	
            }
            public void insertUpdate(DocumentEvent e) 
            {
            	Document doc = (Document)e.getDocument();
            	String string = null;
            	try {
					string = doc.getText(0, doc.getLength());
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
            	s.push(string);
            	s.push(string.split(" ")[0] + string.split(" ")[1]);
            }

            public void removeUpdate(DocumentEvent e) 
            {

            }
        });
		this.add(text);
		button = new JButton("Undo");
		button.setBounds(0,30,100,30);
		button.addActionListener(this);
		this.add(button);
		this.setFocusable(true);
	}
	public Dimension getPreferredSize() {
		return new Dimension(800,800);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}

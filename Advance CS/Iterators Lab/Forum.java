import java.util.ArrayList;
import javax.swing.JTextField;
public class Forum{
	private ArrayList<JTextField> inputs;
	public Forum(){
		 inputs= new ArrayList<JTextField>();
	}
	public void addElement(JTextField input){
		inputs.add(input);
	}
	public JTextField getElement(int position){
		return inputs.get(position);
	}
	public ArrayList<JTextField> getArray(){
		return inputs;
	}
	public String submit(int position){
		return inputs.get(position).getText();
	}
}
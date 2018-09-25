import java.io.*;
public class Writer{
	private String path;
	public Writer(String path){
		this.path = path;
	}
	public void writeToFile(String text) throws IOException{
		FileWriter write = new FileWriter(path,false);
		PrintWriter print = new PrintWriter(write);
		print.printf("%s",text);
		print.close();
	}
}
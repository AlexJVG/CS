
public class Education{
	private String school;
	private String gradDate;
	public Education(String school, String gradDate){
		this.school = school;
		this.gradDate = gradDate;
	}
	public int getYear(){
		return Integer.parseInt(gradDate.substring(0,4));
	}
	public int getMonth(){
		return Integer.parseInt(gradDate.substring(5));
	}
	public String toString(){
		return "School: " + school +" - Graduation Date: "+ gradDate+"\n";
	}
}
public class Patient implements Comparable<Patient> {
    private String lastName;
    private String firstName;
    private String illness;
    private int priority;
    private String note;
    private double billing;
    private long timestamp;
    public Patient(String lastName,String firstName,String illness,String priority,long timestamp){
        this.lastName = lastName;
        this.firstName = firstName;
        this.illness = illness;
        if(priority.toLowerCase().equals("high")){
            this.priority= 0;
        }else if(priority.toLowerCase().equals("medium")){
            this.priority= 1;
        }else if(priority.toLowerCase().equals("low")){
            this.priority= 2;
        }
        this.note = "";
        this.billing = 0.0;
        this.timestamp = timestamp;
    }
    public String toString(){
        String temp = "";
        if(priority==0){
            temp = "High";
        }else if(priority==1){
            temp = "Medium";
        }else if(priority==2){
            temp = "Low";
        }
        return "Name: "+lastName+" "+firstName+"\nIllness: "+illness+"\nPrioity: "+temp+"\nNote: "+ note+"\nBilling: "+billing+"\nTime when admitted: "+timestamp;
    }
    public boolean findPatient(String lastName,String firstName){
        if(this.lastName.equals(lastName)&&this.firstName.equals(firstName)){
           return true;
        }
        else{
            return false;
        }
    }
    public void updateIllness(String illness){
        this.illness = illness;
    }
    public void updatePriority(String priority){
        if(priority.toLowerCase().equals("high")){
            this.priority= 0;
        }else if(priority.toLowerCase().equals("medium")){
            this.priority= 1;
        }else if(priority.toLowerCase().equals("low")){
            this.priority= 2;
        }
    }
    public String getName(){
        return firstName+" "+lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getIllness(){
        return illness;
    }
    public void updateNote(String note){
        this.note = note;
    }
    public int compareTo(Patient other){
        if(this.priority<other.priority){
            return -1;
        }else if(this.priority>other.priority){
            return 1;
        }else {
            if (this.timestamp < other.timestamp) {
                return -1;
            } else if (this.timestamp > other.timestamp) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}

public class CellPhone{
  private long phoneNumber;
  private int id;
  private int date;

  public CellPhone(long phoneNumber,int id){
    this.phoneNumber = phoneNumber;
    this.id = id;
  }
  public CellPhone(long phoneNumber, int id, int date){
    this.phoneNumber = phoneNumber;
    this.id = id;
    this.date = date;
  }
  public long getPhoneNumber(){
    return phoneNumber;
  }
  
  public int getId(){
    return id;
  }

  public int getDate(){
    return date;
  }
 
  public String toString(){
    return "Phone number: " + phoneNumber + " ID: " + id + " Date: " + date;
  }
}
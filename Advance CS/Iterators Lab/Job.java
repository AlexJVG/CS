public class Job {
    private String jobTitle;
    private String companyName;
    private String startDate;
    private String endDate;
    private String workFunction;

    public Job(String jobTitle, String companyName,String startDate, String endDate,String workFunction) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.workFunction = workFunction;
    }
    public int getYear() {
        return Integer.parseInt(endDate.substring(0, 4));
    }
    public int getMonth() {
        return Integer.parseInt(endDate.substring(5));
    }
    public String toString() {
        return "Job Title: "+ jobTitle + "\nCompany Name: "+ companyName + "\nStart Date: "+ startDate + "\nEnd Date: " + endDate+"\nJob Function: "+workFunction+"\n\n";
    }
}
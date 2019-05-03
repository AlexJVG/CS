import java.util.*;
public class Task implements Runnable{
	private boolean task_complete;
	public Task(){
		this.task_complete = false;
	}
	public void run(){
		if(!this.task_complete){
			String task_name = Thread.currentThread().getName();
			long task_id = Thread.currentThread().getId();
			int random = new Random().nextInt(2);
			System.out.println(task_name+": Starting");
			if(random == 0){
				for(int i=0;i<2;i++){
					System.out.println(task_id+": "+(i+1));
				}
			}else if(random == 1){
				for(int i=0;i<3;i++){
					System.out.println(task_id+": "+(i+1));
				}
			}
			System.out.println(task_name+": Completed");
			this.task_complete = !this.task_complete;
		}
	}
	public String toString(){
		if(this.task_complete){
			return Thread.currentThread().getName()+": Completed";
		}else{
			return Thread.currentThread().getName()+": Not Finished";
		}
	}
	public boolean completed(){
		return this.task_complete;
	}
}
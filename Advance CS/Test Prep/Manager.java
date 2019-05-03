import java.util.*;
public class Manager{
	private ArrayList<Task> list_task;
	private ArrayList<Thread> list_thread;
	private int thread_index;
	private int task_index;
	public Manager(){
		this.list_task = new ArrayList<>();
		this.list_thread = new ArrayList<>();
		this.thread_index = 0;
		this.task_index = 0;
		for(int i =0;i<new Random().nextInt((20) + 1) + 30;i++){
			this.list_task.add(new Task());
		}
		for(int i =0;i<5;i++){
			this.list_thread.add(new Thread());
		}
	}
	private void startThread(int index,int task_index){
		this.list_thread.set(index,new Thread(list_task.get(task_index)));
		this.list_thread.get(index).start();
	}
	public void start(){
		while(true){
			if(task_index==list_task.size()&&list_task.get(task_index-1).completed()){
				break;
			}else{
				for(int i =0;i<5;i++){
						if(this.thread_index==5){
							this.thread_index = 0;
						}
						startThread(this.thread_index,this.task_index);
						this.thread_index++;
						this.task_index++;
				}
				// try{
				// 	this.list_thread.get(0).join();		
				// 	this.list_thread.get(1).join();		
				// 	this.list_thread.get(2).join();		
				// 	this.list_thread.get(3).join();		
				// 	this.list_thread.get(4).join();				
				// }catch(Exception e){
				// 	System.out.println(e);
				// }
			}
		}
	}
	public void printStateOfList(){
		for(Task each : list_task){
			System.out.println(each);
		}
	}
}
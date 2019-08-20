public class ColManager implements Runnable{
	public void run(){
		while(true){
			synchronized(this){
				if(Thread.interupted()){
					break;
				}
				for(Long en : Runner.list_enemy_id){
					for(Long pro: Runner.list_projectile_id){
						System.out.println(Runner.list_enemy_id.size());
						try{
							if(Runner.manager_projectile.get(pro).col(Runner.manager_enemy.get(en))){
								System.out.println("testing");
								Runner.list_collisons.put(pro,en);
								break;
							}
						}catch(Exception e){}
					}
				}
			}
		}
	}
}
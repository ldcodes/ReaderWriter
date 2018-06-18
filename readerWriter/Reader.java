package readerWriter;

public class Reader extends Thread {

	public void run() {		
		    System.out.println(this.getName()+" is waiting for mutex"+Solution.p());
			try {
			    Solution.mutex.acquire();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			Solution.reader.getAndIncrement();
			System.out.println(this.getName()+" is coming in "+Solution.p());
			if(Solution.reader.get()==1){
				 System.out.println(this.getName()+" is waiting  for wtiter  "+Solution.wrt.availablePermits()+Solution.p());
				try{
				   Solution.wrt.acquire();
			    }catch(InterruptedException e){
				     e.printStackTrace();
			    }
			}			
			Solution.mutex.release();

			reading();

			System.out.println(this.getName()+" is waiting  for leaving"+Solution.p());
			try {
				Solution.mutex.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Solution.reader.getAndDecrement();
			if(Solution.reader.get()==0)
			    Solution.wrt.release();
			Solution.mutex.release();	
			System.out.println(this.getName()+" is leaving d"+Solution.p());
	}
	
	public void reading() {
		System.out.println(this.getName()+"  is reading  "+Solution.p());
		try {
			this.sleep(3);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}

package readerWriter;

public class Writer extends Thread {

	public void run(){
		
          while(true){
        	  
        	  //first ,otherwise reader will be clock by writer  
        	  System.out.println("writer is waiting for reader   "+Solution.reader.get() +Solution.p());
			  try{
				  Solution.wrt.acquire();
			  }catch(InterruptedException e){
				  e.printStackTrace();
			  }
        	  System.out.println("writer is waiting for mutex " +Solution.p());
			  try{
				  Solution.mutex.acquire();
			  }catch(InterruptedException e){
				  e.printStackTrace();
			  }
			  
			  
			  writing();
			  Solution.wrt.release();
			  Solution.mutex.release();
			  System.out.println("writer is leaving"+Solution.p());
			  try{
				  this.sleep(2);
			  }catch(InterruptedException e){
				  e.printStackTrace();
			  }
			  
		  }

	}

	public void writing(){
        System.out.println("writer is writing" +Solution.p());
	}

}

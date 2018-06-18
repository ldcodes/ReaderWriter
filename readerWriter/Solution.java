package readerWriter;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

	public static Semaphore mutex = new Semaphore(1);
	public static Semaphore wrt = new Semaphore(1);
	public static AtomicInteger reader =  new AtomicInteger(0);
	
	public static void main(String  argms[]){
		Writer writer = new Writer();
		writer.setDaemon(true);
		writer.start();
		int time = 0;
		while( time < 20 ){
			if(new Random().nextFloat()>0.5) {
				new Reader().start();
				time++;
				try {
					Thread.currentThread().sleep(5);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}


	}
	
	public static String p() {
		return ("  mutex :"+mutex.availablePermits()+"  reader :"+reader.get()+"  writer :"+wrt.availablePermits());
	}
	
}


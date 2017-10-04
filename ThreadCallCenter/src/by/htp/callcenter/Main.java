package by.htp.callcenter;

public class Main {

	public static void main(String[] args)  {
		
		CallCenter callcenter = new CallCenter();
		
		Caller c1 = new Caller(callcenter, "Caller1");
		Caller c2 = new Caller(callcenter, "Caller2");
		Caller c3 = new Caller(callcenter, "Caller3");

		c1.start();
		c2.start();
		c3.start();
		
		c1.interrupt();
		c2.interrupt();
		c3.interrupt();
		
		try {
			c1.join();
			c2.join();
			c3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("FINISH");
	}

}

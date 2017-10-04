package by.htp.callcenter;

public class CallCenter {
	
	public synchronized void talkToOperator1() {
		System.out.println("Caller talks to Operator 1");
		
	}

	public synchronized void talkToOperator2() {
		System.out.println("Caller talks to Operator 2");
		
	}

	public synchronized void talkToOperator3() {
		System.out.println("Caller talks to Operator 3");
		
	}

}

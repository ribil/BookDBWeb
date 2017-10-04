package by.htp.callcenter;

public class Caller extends Thread{
	
	private CallCenter callcenter;

	private String callerName;
	
	@Override
	public void run() {
		System.out.println(this.getCallerName() +" STARTS!");
		callcenter.talkToOperator1();
		
		callcenter.talkToOperator2();
		
		callcenter.talkToOperator3();
		
		
	}
	
	public Caller(CallCenter callcenter, String callerName) {
		super();
		this.callcenter = callcenter;
		this.callerName = callerName;
	}

	public Caller(String callerName) {
		super();
		this.callerName = callerName;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}


	

}

package ie.gmit.sw;

public class CodeTimer {

	private long executionTime;
	
	public CodeTimer() {
		this.executionTime=0;
	}
	
	public void startTimer() {
		this.executionTime=System.nanoTime();
	}
	
	public void stopTimer() {
		this.executionTime=System.nanoTime() - executionTime;
	}
	
	public void resetTimer() {
		this.executionTime=0;
	}
	
	public long getExecutionTime() {
		return executionTime;
	}
	
	public String toString()
	{
		String timerDescription = "Current execution time is: " + this.executionTime + " in Nano seconds";
		
		return timerDescription;
	}
	
	
}

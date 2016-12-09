
public class Job implements Comparable<Job> {
	String name;
	int runTime;
	int arrivalTime;
	int responceTime;
	int completion_time;
	int ComplCheck = 0;
	//class scope variable
	public Job( String name, int runTime, int arrivalTime){
		this.name =name;
		this.runTime = runTime;
		this.arrivalTime = arrivalTime;
		}
	@Override
	  public String toString() {
	    return name;
	  }
	public int compareTo(Job compareJob) {
		int compareQuantity = ((Job) compareJob).arrivalTime;
		return this.arrivalTime-compareQuantity;
	}

}

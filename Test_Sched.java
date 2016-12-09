/*Michael Pereira
 * Project 4
 * CMP436 */
import java.util.Arrays;

public class Test_Sched {
	static int TotalRuntime;
	int completion_Time= TotalRuntime;
	int Responce_time;//remember to set both within each method
	//for now stick to four
	
	public void RoundRobin(Job[] x){
		/*Assuming the array is sorted, and assuming that cpu time per job is a constant
		 * the "For" loop signifies one iteration thru the jobs as the time slice in round robin
		 * and the "while" loop is to ensure the that the jobs are completed.*/
		int y = 0;
		Responce_time = 0;
		while(y!=TotalRuntime){
			for(int j = 0; j < x.length; j++){
				if(y == 0){
					x[j].responceTime = Responce_time;//sets response time
					System.out.println("Job "+x[j].name +" responce time was : "+ x[j].responceTime);
				}
				if(x[j].runTime > 0){
					x[j].runTime = x[j].runTime - 1;// 10 second slice
					completion_Time--;
					
				}
				if(x[j].runTime == 0){
					if(x[j].ComplCheck == 0){
						x[j].completion_time = TotalRuntime - completion_Time;//set Completion time
						System.out.println("Job "+x[j].name+" Completed at "+ x[j].completion_time);
						x[j].ComplCheck = 1;
					}
				}
				Responce_time = Responce_time+1;
			}
			y++;
		}
	}
	public void SJF(Job[] x){/*Assuming sorted by arrival time, then resorts the runtime to excutes shortest job first*/
		Responce_time = 0;
		for(int i=0; i<x.length;i++){//assuming arrival time is sorted
			for(int j=0; j<x.length;j++)//checks other elements for smaller runtime
				if(x[i].arrivalTime == x[j].arrivalTime && x[i].runTime > x[j].runTime){
					Job temp =x[i];//swaps
					x[i] = x[j];
					x[j]= temp;
				}
		}//now arrival time and runtime is sorted to the algorithm of the shortest job first
		for(int k=0;k<x.length;k++){
			if(k==0){
				x[k].responceTime = 0;
				System.out.println("Job "+x[k].name+" Responce Time was : "+ x[k].responceTime);
				Responce_time = Responce_time + x[k].runTime;
				x[k].completion_time = Responce_time;
				System.out.println("Job "+x[k].name +" completed at "+ x[k].completion_time);
			}
			if(k!=0){
				x[k].responceTime = Responce_time;
				System.out.println("Job "+x[k].name+" Responce Time was : "+ x[k].responceTime);
				Responce_time = Responce_time + x[k].runTime;
				x[k].completion_time = Responce_time;
				System.out.println("Job "+x[k].name +" completed at "+ x[k].completion_time);
			}
		}
	}

	public static void main(String[] args) {
		//for RR
		Job[] TheJobs = new Job[4];//edit here("name",Runtime,Arrival_time)
		Job job_A = new Job("A",1,7);//name,runtime,arrival_time
		Job job_B = new Job("B",2,9);
		Job Job_C = new Job("C",1,8);
		Job job_D = new Job("D",3,9);
		TotalRuntime = job_A.runTime + job_B.runTime + Job_C.runTime + job_D.runTime;
		TheJobs[0]=job_A;
		TheJobs[1]=job_B;
		TheJobs[2]=Job_C;
		TheJobs[3]=job_D;
		Arrays.sort(TheJobs);
		
		//for SJF
		Job[] TheJob = new Job[4];//edit here("name",Runtime,Arrival_time)
		Job job_E = new Job("E",1,7);//name,runtime,arrival_time
		Job job_F = new Job("F",2,9);
		Job Job_G = new Job("G",1,8);
		Job job_H = new Job("H",3,9);
		TheJob[0]=job_E;
		TheJob[1]=job_F;
		TheJob[2]=Job_G;
		TheJob[3]=job_H;
		Arrays.sort(TheJob);
		///////////////////
		Test_Sched test_RR = new Test_Sched();
		System.out.println("Using Round robin :");
		test_RR.RoundRobin(TheJobs);
		Test_Sched test_sjf = new Test_Sched();
		System.out.println("Using Shortest Job First :");
		test_sjf.SJF(TheJob);
		}
}



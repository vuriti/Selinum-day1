package Day3;

public class Car extends Machine {
	
	public Car() {
		engsize =300;
		System.out.println("i am cunstrocter of CAR");
	}
	
	public void re_strat(){
		
		System.out.println("re-strat from car");
		
		start();
		stop();
		
		
	}

}

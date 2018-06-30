package Day3;

public class Employee_con {

	private int sal;
	private int bouns;
	
	public void setsal( int sal) {
		if (sal<0) {
			System.out.println("invalid");
		}else {
			this.sal =sal;
			
		}
	}
	
	// constructer
	public Employee_con() {
		System.out.println("i am contsructer");
		sal =100;
		bouns=5000;
		
		
	
	}
	
	public Employee_con(int sal,int bouns){
		
		System.out.println("iam overload");
		this.sal= sal;
		this.bouns =bouns;
		
				
	}
	
	int calSal() {
		int Totalsal = sal+bouns;
		
		return Totalsal;
		
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getBouns() {
		return bouns;
	}

	public void setBouns(int bouns) {
		this.bouns = bouns;
	}
	
}

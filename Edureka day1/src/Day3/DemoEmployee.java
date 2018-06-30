package Day3;

public class DemoEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//construer a method with same name as that of class it dosen not resturn anzthing not even null
		// it is used assiging default value
		//if calss dosent have 
		
		Employee_con Ravi = new Employee_con();
		
		int salary = Ravi.calSal();
		
		System.out.println(salary);
		
		Employee_con teja= new Employee_con(600,500);
		
		teja.setsal(-500);
		
		System.out.println(teja.calSal());
		
		
		//encapsilation warping up the data(variables) and behaviour (methods) together in one signle unit (class)
		
		//In Encapsulation, the varibles of class

	}

}

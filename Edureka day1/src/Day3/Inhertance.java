package Day3;

public class Inhertance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Machine mac = new Machine();
		
		mac.start();
		mac.stop();
		System.out.println("----------------------");
		
		Car bmw = new Car();
		bmw.start();
		bmw.stop();
		bmw.re_strat();
		System.out.println("-------------------");
		
		Machine alto = new Car();
				alto.start();
		alto.stop();
		System.out.println(alto.engsize);
		System.out.println("---------------------------");	
	}

}

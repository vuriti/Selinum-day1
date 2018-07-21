package assignment4;

public class Execute {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub

		flightmodules indigo = new flightmodules();
		
		indigo.openbrowser("chrome");
		indigo.launchurl();
		indigo.search();
		indigo.getallflights();
	}

}

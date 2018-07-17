package assigment3;

public class WorkingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			Workingmethods edu = new Workingmethods();

			edu.openbrowser("chrome");
			edu.openurl();
			edu.actionsonapp();
			edu.closeurl();

		} catch (Exception e) {

			System.out.println("*************************");
		  e.printStackTrace();
			System.out.println("an EXpection occered");
		}
	}

}

package day2part2;

public class DemoEmpolyee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declaring an objet

		Employee ravi;

		// instantiation and initialization

		ravi = new Employee();

		ravi.Name = "RaviTeja";
		ravi.sal = 50000;
		ravi.bonus=200;
		ravi.calculate();
		
		// all methosd will return some type of value int,
		// if method don not retrun any value it will be void
		
		int totalsal= ravi.cal2(4500,500);
		System.out.println("total salary:" + totalsal);
		


	}

}

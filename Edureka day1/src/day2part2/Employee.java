package day2part2;

public class Employee {

	// this a class :which is templet for all employee

	int sal;
	int bonus;
	String Name;

	void calculate() {

		System.out.println("employee name is" + Name + " and sal is :" + sal);
		System.out.println("total amount :" + (sal + bonus));

	}

	int cal2(int salary, int b1) {
		int total;
		
		total =salary+b1;
		return total;
			}
}

package Day2;

public class operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// assignment "="
		// aurthamatic opertors "+,-,/,*,%,++,--
		// when we use + it will act as & when one one of the varible is string

		int no1;
		int no2;
		no1 = 100;
		no2 = 50;
		System.out.println("use of + :" + (no1 + no2));
		System.out.println("use of - :" + (no1 - no2));
		System.out.println("use of / :" + (no1 / no2));
		System.out.println("use of * :" + (no1 * no2));
		System.out.println("use of % :" + (no1 % no2));
		System.out.println("use of ++ :" + (++no1));
		System.out.println("use of ++ :" + (no1));
		System.out.println("use of ++ :" + (no1++));
		System.out.println("use of ++ :" + (no1));

		// relational opreators ">,<,<<,>>,==

		int firstnum, secondnum, thirdnum;

		firstnum = 100;
		secondnum = 200;
		thirdnum = 300;

		if (firstnum > secondnum && firstnum > thirdnum) {
			System.out.println("firts number is big");
		} else if (secondnum > firstnum && secondnum > thirdnum) {
System.out.println("second is big");
		}else if (thirdnum> firstnum && thirdnum>secondnum);{
		System.out.println("rd number big");
		}
		
		
		if (no1<no2) {
			System.out.println("number  is big");
		}else {
			System.out.println("nuber 1 is big");
		}
			
		}

}

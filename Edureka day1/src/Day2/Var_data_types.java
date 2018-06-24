package Day2;

public class Var_data_types {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//  Premitive data types : Predifine by progaming language
		// byte,short,int,long, these are integer
		// float,double- with decimal number
		// char
		// boolean (true&false)
		//non Premitive data types: 
		// String
		//****Example below***//
		
		int Number;
		
		Number= 25;
		
		System.out.println("int value:" + Number);
		
		//when we use long value we should use "l" in after  other eise if we sen the long value with out l it will thorugh error
		// in long we can store interger but vice versa is not possible
		
		long second_number;
		second_number= 31458645665l;
		System.out.println("long value is:" + second_number );
		
		//flote and double is for decimals
		
		float decimal_one;
		
		decimal_one= 1586.56f;
		System.out.println("floate value : "+ decimal_one);
		
		//boolen will show the true or false
		
		boolean status;
		
		status= 9>10;
		
		System.out.println("staus is: "+ status);
		
		status =10<11;
		System.out.println("staus is: "+ status);
		
		
		
	}

}

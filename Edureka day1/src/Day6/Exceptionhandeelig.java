package Day6;

public class Exceptionhandeelig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[5];

		try {

			arr[0] = 10;
			arr[1] = 12;
			arr[2] = 15;
			arr[3] = 16;
			arr[4] = 17;

			for (int i = 0; i <= 5; i++) {
				System.out.println(arr[i]);

			}

		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace();
			System.out.println("123");
		} catch (RuntimeException e) {
			System.out.println("an EXpection occered");
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(" excpetion");
		}
		System.out.println("done");

	}

}

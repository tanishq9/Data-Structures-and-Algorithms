package OOPS2;

public class throwsKeyword {

	// try-catch or throws keyword are used for checked exceptions
	public static void main(String[] args) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

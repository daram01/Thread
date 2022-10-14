package Thread;

public class AccountHolderTest {

	public static void main(String[] args) {
//		// 하나의 통장에서 두명이 돈을 찾게 되는 구조가 된다.
		Runnable r = new AccountHolder();
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);

		th1.start();
		th2.start();
		
	}

}

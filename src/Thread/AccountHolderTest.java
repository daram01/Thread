package Thread;

public class AccountHolderTest {

	public static void main(String[] args) {
//		// �ϳ��� ���忡�� �θ��� ���� ã�� �Ǵ� ������ �ȴ�.
		Runnable r = new AccountHolder();
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);

		th1.start();
		th2.start();
		
	}

}

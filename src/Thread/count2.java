package Thread;

public class count2 implements Runnable{

	@Override
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1�ʿ� �ѹ��� �ݺ��� �������� ���� ��
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}

package Thread;

public class count2 implements Runnable{

	@Override
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초에 한번씩 반복문 돌리도록 만든 것
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}

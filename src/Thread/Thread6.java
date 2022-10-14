package Thread;

public class Thread6 implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName()); // 쓰레드의 이름을 출력하는 코드
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	

}

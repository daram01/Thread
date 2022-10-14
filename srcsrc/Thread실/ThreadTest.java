package Thread;

import javax.swing.JOptionPane;

public class ThreadTest {

	public static void main(String[] args) {
			// 프로그램 -> 프로세스 -> 쓰레드(멀티쓰레드
		// 프로세스라는 작업공간에서 작업을 처리하는 일꾼 = 쓰레드
		// 모든 프로그램은 기본적으로 쓰레드가 동작한다.(최소 1개 이상의 쓰레드가 있다.)
		// 쓰레드 만드는 방법 - 두가지
		// 1. Thread class를 상속
		// - 클래스를 직접 생성
		// 2. Runnable 인터페이스 상속
		// - 다중 상속을 하는 경우 사용한다.
		// - 두번의 생성 과정을 거친다.
		// - 클래스를 생성 후 다시 한번 Thread클래스의 생성자를 사용해서 다시 한 번 생성한다.
		
		// 쓰레드 제어
		// Thread.sleep(1000); 쓰레드의 일시 정지 시간
		// wait() 쓰레드를 일시 정지로 만들어 줌 - notify() 쓰레드를 실행 대기 상태로 만들어 줌// 프로그램 -> 프로세스 -> 쓰레드(멀티쓰레
		
//		for(int i=0;i<10;i++) {
//			System.out.println(i);
//		}
//		
//		for(int j=0;j<10;j++) {
//			System.out.println(j);
//		}
		
//		//클래스를 이용한 방식 (Thread 클래스를 상속 받은 경우)
//		count c = new count(); 
//		c.start();
		
		
//		//인터페이스를 이용한 방식 (Runnable 인터페이스를 상속받은 경우)
//		Runnable r = new count2();
//		Thread c2 = new Thread(r); //c2에 r객체를 넣어준다.
//		c2.start();
//		
//		
//		//원쓰레드 
//		String input = JOptionPane.showInputDialog("아무값이나 입력");
//		System.out.println("입력값은 " + input + " 입니다.");
		
		// 위가 출력이 되고 나서야 밑의  for문이 동작함
		
//		for(int i=10;i>0;i--) {
//			System.out.println(i);
//			try {
//				Thread.sleep(1000); // 1초에 한번씩 반복문 돌리도록 만든 것
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
//		Threadex5 th = new Threadex5();
//		th.start();
//		
//		for (int i=0;i<500;i++) {
//			System.out.print("-");
//		} // 세로(|) 보다 가로(-)가 먼저 찍히지 않음. 시작과 끝의 순서는 예측할 수가 없다. 
		
		
		// Thread6
		Runnable r = new Thread6();
		Thread th1 = new Thread(r,"*");
		Thread th2 = new Thread(r,"**");
		Thread th3 = new Thread(r,"***");
		
		th1.start();
		th2.start();
		th3.start();
		
		//쓰레드 제어
		try {
			Thread.sleep(2000); // 현재 자신을 호출한 쓰레드를 슬립한다. (일시정지) // 메인에서 호출했기 때문에 메인클래스 쓰레드를 슬립하는 것임.
			th1.suspend(); // 쓰레드 일시정지
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume(); // suspend 상태의 th1을 실행 대기 상태로 돌림
			Thread.sleep(3000);
			th2.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

	} // main end

}

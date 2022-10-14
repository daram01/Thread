package Thread;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account { // 통장
	private int balance = 1000;
	
	// 쓰레드 th1, th2는 경합중이기 때문에 if문에서 먼저 sleep된 쓰레드가 있는 경우 balance의 값이 0이 되지 못했기 때문에 
	// 잔고가 마이너스까지 차감이 되어버림 ( 결과값 -100, 이런식으로 나옴)
	// 그렇기 때문에 synchronized 를 추가해줌.
	// 동기화 : 순서를 지켜서 사용하게 한다.
	
			//synchronized -> 잠그다. 메소드에서 사용하는 것임
	public /* synchronized -> 특정 범위*/ void withdraw /* 출금기능 */ (int money) { // 잔고에서 원하는 금액만큼 찾을 수 있게 한 메소드
		synchronized (this) /* 더 넓은 범위 */ {
			if(balance >= money) { // 잔고가 money보다 크거나 같을때만 돌아가게 한 기능
				try {
					Thread.sleep(1000); // 1초 있다가 돈 차감하게 만듬
				}catch(Exception e) {
					e.printStackTrace();
				}
				balance -= money;
			}
		}
	}
	
} //class end

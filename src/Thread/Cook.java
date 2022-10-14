package Thread;

public class Cook/* 요리사 */ implements Runnable {
	//cook->table->customer 의 구조
	//요리사가 요리를 만들면 2가지 종류로, 최대 6개까지 셋팅된다.
	//하나는 햄버거, 하나는 도너츠. 만드는 비율은 랜덤이다.
	//손님은 한 명이 아니고 두 명이다. 한 명은 햄버거만, 한 명은 도너츠만 먹을 수 있다.
	//그렇게 되면 요리사(cook)은 음식을 만들지 않고 쉰다.(쓰레드의 일시정지) wait()
	//손님(customer)은 테이블에 본인이 먹을 수 있는 음식이 없으면 먹지 않는다. (일시정지) wait()
	//wait가 걸리기 전에 요리사가 고객한테 음식을 만들었으니, 먹으라고 통보를 한다. notify()
	
	// wait - notify 사용조건 : 동기화(synchronized)가 정의된 메소드에서만 사용된다.
	
	private Table table; //테이블 변수 선언 
	
	
	//생성자
	protected Cook(Table table) {
		super();
		this.table = table;
	}



	@Override
	public void run() { //요리를 만드는 메소드
		while(true) {							// 0부터 2까지
			int idx = (int)(Math.random() * table.dishName());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}

package Thread;

public class Customer/*손님 */ implements Runnable {
	
	private Table table; //테이블 변수 선언 
	private String food;
	
	
	
	// 생성자를 통한 초기화
	protected Customer(Table table, String food) {
		super();
		this.table = table;
		this.food = food;
	}


	@Override
	public void run() { //접시에 있는 음식을 먹는 역할
		while(true) {
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			String name = Thread.currentThread().getName();
			table.remove(food);
			System.out.println(name + " ate " + food);
		}
	}
	
} // class end

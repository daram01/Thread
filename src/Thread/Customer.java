package Thread;

public class Customer/*�մ� */ implements Runnable {
	
	private Table table; //���̺� ���� ���� 
	private String food;
	
	
	
	// �����ڸ� ���� �ʱ�ȭ
	protected Customer(Table table, String food) {
		super();
		this.table = table;
		this.food = food;
	}


	@Override
	public void run() { //���ÿ� �ִ� ������ �Դ� ����
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

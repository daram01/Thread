package Thread;

public class Cook/* �丮�� */ implements Runnable {
	//cook->table->customer �� ����
	//�丮�簡 �丮�� ����� 2���� ������, �ִ� 6������ ���õȴ�.
	//�ϳ��� �ܹ���, �ϳ��� ������. ����� ������ �����̴�.
	//�մ��� �� ���� �ƴϰ� �� ���̴�. �� ���� �ܹ��Ÿ�, �� ���� �������� ���� �� �ִ�.
	//�׷��� �Ǹ� �丮��(cook)�� ������ ������ �ʰ� ����.(�������� �Ͻ�����) wait()
	//�մ�(customer)�� ���̺� ������ ���� �� �ִ� ������ ������ ���� �ʴ´�. (�Ͻ�����) wait()
	//wait�� �ɸ��� ���� �丮�簡 ������ ������ ���������, ������� �뺸�� �Ѵ�. notify()
	
	// wait - notify ������� : ����ȭ(synchronized)�� ���ǵ� �޼ҵ忡���� ���ȴ�.
	
	private Table table; //���̺� ���� ���� 
	
	
	//������
	protected Cook(Table table) {
		super();
		this.table = table;
	}



	@Override
	public void run() { //�丮�� ����� �޼ҵ�
		while(true) {							// 0���� 2����
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

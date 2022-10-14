package Thread;

import java.util.ArrayList;

public class Table /*�丮�� �÷� ���� �� */ {
	String[] dishNames = {"donut", "donut", "burger"}; // �丮�� �迭�� ���
	final int MAX_FOOD = 6; // �丮�� ������ ����� ����
	
			//�ִ� 6���� ���� ����.
	private ArrayList<String> dishes = new ArrayList<String>(); // ���� �ְ�, �ߺ� ����.
	
	public synchronized void add(String dish) { // ���ÿ� ������ �߰��ϴ� �޼ҵ�
		while(dishes.size() >= MAX_FOOD)	{
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting ");
			
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		dishes.add(dish);
		notify();
		System.out.println("Dishes : " + dishes.toString());
	}
	
	public synchronized void remove(String dishName) { // ���� ������ �Դ´�. ������ �� �Ծ��� �� ���ø� ���ִ� �޼ҵ�
		String name = Thread.currentThread().getName(); // 1�� ���� ������ �Դ���, 2�� ���� ������ �Դ��� �� �� �ִ�.
		
		while(dishes.size() == 0) {
			System.out.println(name + " is waiting ");
			
			try {
				wait();
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		while(true) {
			for(int i=0;i<dishes.size();i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					notify();
					return;
				}
			}
			try {
				System.out.println(name + " is waiting ");
				wait();
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int dishName() { // ���� �迭�� ũ�⸦ ��ȯ�ϴ� ����
		return dishNames.length; // ũ�Ⱑ 3
	}
}

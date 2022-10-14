package Thread;

import java.util.ArrayList;

public class Table /*요리를 올려 놓는 곳 */ {
	String[] dishNames = {"donut", "donut", "burger"}; // 요리를 배열에 담기
	final int MAX_FOOD = 6; // 요리의 갯수를 상수로 설정
	
			//최대 6개의 값이 들어간다.
	private ArrayList<String> dishes = new ArrayList<String>(); // 순서 있고, 중복 가능.
	
	public synchronized void add(String dish) { // 접시에 음식을 추가하는 메소드
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
	
	public synchronized void remove(String dishName) { // 고객이 음식을 먹는다. 음식을 다 먹었을 때 접시를 빼주는 메소드
		String name = Thread.currentThread().getName(); // 1번 고객이 음식을 먹는지, 2번 고객이 음식을 먹는지 알 수 있다.
		
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
	
	public int dishName() { // 현재 배열의 크기를 반환하는 역할
		return dishNames.length; // 크기가 3
	}
}

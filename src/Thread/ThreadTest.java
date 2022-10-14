package Thread;

import javax.swing.JOptionPane;

public class ThreadTest {

	public static void main(String[] args) {
		// ���α׷� -> ���μ��� -> ������(��Ƽ������)
		// ���μ������ �۾��������� �۾��� ó���ϴ� �ϲ� = ������
		// ��� ���α׷��� �⺻������ �����尡 �����Ѵ�.(�ּ� 1�� �̻��� �����尡 �ִ�.)
		// ������ ����� ��� - �ΰ���
		// 1. Thread class�� ���
		// 2. Runnable �������̽� ���
		
//		for(int i=0;i<10;i++) {
//			System.out.println(i);
//		}
//		
//		for(int j=0;j<10;j++) {
//			System.out.println(j);
//		}
		
//		//Ŭ������ �̿��� ��� (Thread Ŭ������ ��� ���� ���)
//		count c = new count(); 
//		c.start();
		
		
//		//�������̽��� �̿��� ��� (Runnable �������̽��� ��ӹ��� ���)
//		Runnable r = new count2();
//		Thread c2 = new Thread(r); //c2�� r��ü�� �־��ش�.
//		c2.start();
//		
//		
//		//�������� 
//		String input = JOptionPane.showInputDialog("�ƹ����̳� �Է�");
//		System.out.println("�Է°��� " + input + " �Դϴ�.");
		
		// ���� ����� �ǰ� ������ ����  for���� ������
		
//		for(int i=10;i>0;i--) {
//			System.out.println(i);
//			try {
//				Thread.sleep(1000); // 1�ʿ� �ѹ��� �ݺ��� �������� ���� ��
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
//		Threadex5 th = new Threadex5();
//		th.start();
//		
//		for (int i=0;i<500;i++) {
//			System.out.print("-");
//		} // ����(|) ���� ����(-)�� ���� ������ ����. ���۰� ���� ������ ������ ���� ����. 
		
		
		// Thread6
		Runnable r = new Thread6();
		Thread th1 = new Thread(r,"*");
		Thread th2 = new Thread(r,"**");
		Thread th3 = new Thread(r,"***");
		
		th1.start();
		th2.start();
		th3.start();
		
		//������ ����
		try {
			Thread.sleep(2000); // ���� �ڽ��� ȣ���� �����带 �����Ѵ�. (�Ͻ�����) // ���ο��� ȣ���߱� ������ ����Ŭ���� �����带 �����ϴ� ����.
			th1.suspend(); // ������ �Ͻ�����
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume(); // suspend ������ th1�� ���� ��� ���·� ����
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

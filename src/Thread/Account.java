package Thread;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account { // ����
	private int balance = 1000;
	
	// ������ th1, th2�� �������̱� ������ if������ ���� sleep�� �����尡 �ִ� ��� balance�� ���� 0�� ���� ���߱� ������ 
	// �ܰ� ���̳ʽ����� ������ �Ǿ���� ( ����� -100, �̷������� ����)
	// �׷��� ������ synchronized �� �߰�����.
	// ����ȭ : ������ ���Ѽ� ����ϰ� �Ѵ�.
	
			//synchronized -> ��״�. �޼ҵ忡�� ����ϴ� ����
	public /* synchronized -> Ư�� ����*/ void withdraw /* ��ݱ�� */ (int money) { // �ܰ��� ���ϴ� �ݾ׸�ŭ ã�� �� �ְ� �� �޼ҵ�
		synchronized (this) /* �� ���� ���� */ {
			if(balance >= money) { // �ܰ� money���� ũ�ų� �������� ���ư��� �� ���
				try {
					Thread.sleep(1000); // 1�� �ִٰ� �� �����ϰ� ����
				}catch(Exception e) {
					e.printStackTrace();
				}
				balance -= money;
			}
		}
	}
	
} //class end

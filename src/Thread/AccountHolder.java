package Thread;

public class AccountHolder implements Runnable {
	
	Account acc = new Account();
	
	@Override
	public void run() {
		while(acc.getBalance() > 0) {			//잔고에서 돈을 찾는데, 0원이 될 때 까지.
			int money = (int)(Math.random() * 3 + 1) * 100; // 100원에서 300원 까지의 금액을 랜덤하게.
			acc.withdraw(money);
			System.out.println("balance : " + acc.getBalance());
		}
		
	}

	
}

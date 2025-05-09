package lab.bank.entity;

public abstract class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if (amount <= 0) {
            throw new IllegalArgumentException("입금 금액은 양수여야 합니다.");
        }
        balance += amount;
	}
	
	public abstract void withdraw(double amount) throws Exception;
	
	@Override
	public String toString() {
		return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance;
	}
}

package lab.bank.entity;

import lab.bank.exception.InsufficientBalanceException;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}

	public void applyInterest() {
		double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.printf("���� %.1f���� ����Ǿ����ϴ�. ���� �ܾ�: %.1f��%n", interest, getBalance());
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
    public void withdraw(double amount) throws Exception {
        if (amount > getBalance()) {
            throw new InsufficientBalanceException("�ܾ��� �����մϴ�. ���� �ܾ�: " + getBalance() + "��");
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", ������: %.1f%%", interestRate * 100);
    }
}	

package lab.bank.entity;

import java.util.*;
import lab.bank.exception.*;

public class Bank {
	private List<Account> accounts = new ArrayList<>();
	private int nextAccountNumber = 1000;
	
	public Bank() {
		
	}
	
	public SavingsAccount createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
		if (ownerName == null || ownerName.trim().isEmpty()) {
	        throw new IllegalArgumentException("���� ������ �̸��� null�̰ų� ��� ���� �� �����ϴ�.");
	    }
	    if (initialBalance < 0) {
	        throw new IllegalArgumentException("�ʱ� �ܾ��� 0 �̻��̾�� �մϴ�.");
	    }
	    if (interestRate < 0) {
	        throw new IllegalArgumentException("�������� 0 �̻��̾�� �մϴ�.");
	    }
		String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.printf("���� ���°� �����Ǿ����ϴ�: ���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ������: %.1f%%%n",
                          accountNumber, ownerName, initialBalance, interestRate * 100);
        return account;
	}
	
	public CheckingAccount createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		if (ownerName == null || ownerName.trim().isEmpty()) {
	        throw new IllegalArgumentException("���� ������ �̸��� null�̰ų� ��� ���� �� �����ϴ�.");
	    }
	    if (initialBalance < 0) {
	        throw new IllegalArgumentException("�ʱ� �ܾ��� 0 �̻��̾�� �մϴ�.");
	    }
	    if (withdrawalLimit < 0) {
	        throw new IllegalArgumentException("�������� 0 �̻��̾�� �մϴ�.");
	    }
		String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        System.out.printf("üŷ ���°� �����Ǿ����ϴ�: ���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ��� �ѵ�: %.1f��%n",
                          accountNumber, ownerName, initialBalance, withdrawalLimit);
        return account;
	}
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                       .filter(account -> account.getAccountNumber().equals(accountNumber))
                       .findFirst()
                       .orElseThrow(() ->
                           new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�."));
    }
	
	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
        System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��%n", amount, account.getBalance());
    }
	
	public void withdraw(String accountNumber, double amount) throws Exception {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
        System.out.printf("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��%n", amount, account.getBalance());
    }
	
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws Exception {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);
        fromAccount.withdraw(amount); // ���
        toAccount.deposit(amount);   // �Ա�
        System.out.printf("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.%n", amount, fromAccountNumber, toAccountNumber);
    }
	
	public void printAllAccounts() {
		if (accounts == null || accounts.isEmpty()) {
	        System.out.println("���� ��ϵ� ���°� �����ϴ�.");
	        return;
	    }

	    System.out.println("\n=== ��� ���� ��� ===");
	    for (Account account : accounts) {
	        System.out.println(account);  // toString() �޼��� ȣ��
	    }
	    System.out.println("===================");
    }
}

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
	        throw new IllegalArgumentException("계좌 소유자 이름은 null이거나 비어 있을 수 없습니다.");
	    }
	    if (initialBalance < 0) {
	        throw new IllegalArgumentException("초기 잔액은 0 이상이어야 합니다.");
	    }
	    if (interestRate < 0) {
	        throw new IllegalArgumentException("이자율은 0 이상이어야 합니다.");
	    }
		String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.printf("저축 계좌가 생성되었습니다: 계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%%n",
                          accountNumber, ownerName, initialBalance, interestRate * 100);
        return account;
	}
	
	public CheckingAccount createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		if (ownerName == null || ownerName.trim().isEmpty()) {
	        throw new IllegalArgumentException("계좌 소유자 이름은 null이거나 비어 있을 수 없습니다.");
	    }
	    if (initialBalance < 0) {
	        throw new IllegalArgumentException("초기 잔액은 0 이상이어야 합니다.");
	    }
	    if (withdrawalLimit < 0) {
	        throw new IllegalArgumentException("이자율은 0 이상이어야 합니다.");
	    }
		String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        System.out.printf("체킹 계좌가 생성되었습니다: 계좌번호: %s, 소유자: %s, 잔액: %.1f원, 출금 한도: %.1f원%n",
                          accountNumber, ownerName, initialBalance, withdrawalLimit);
        return account;
	}
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                       .filter(account -> account.getAccountNumber().equals(accountNumber))
                       .findFirst()
                       .orElseThrow(() ->
                           new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다."));
    }
	
	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
        System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원%n", amount, account.getBalance());
    }
	
	public void withdraw(String accountNumber, double amount) throws Exception {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
        System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f원%n", amount, account.getBalance());
    }
	
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws Exception {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);
        fromAccount.withdraw(amount); // 출금
        toAccount.deposit(amount);   // 입금
        System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.%n", amount, fromAccountNumber, toAccountNumber);
    }
	
	public void printAllAccounts() {
		if (accounts == null || accounts.isEmpty()) {
	        System.out.println("현재 등록된 계좌가 없습니다.");
	        return;
	    }

	    System.out.println("\n=== 모든 계좌 목록 ===");
	    for (Account account : accounts) {
	        System.out.println(account);  // toString() 메서드 호출
	    }
	    System.out.println("===================");
    }
}

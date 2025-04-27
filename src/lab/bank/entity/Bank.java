package lab.bank.entity;

import java.util.*;

public class Bank {
	private List<Account> accounts;
	private int nextAccountNumber;
	
	public Bank() {
		
	}
	
	public Account createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
		
	}
	
	public Account createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		
	}
	
	public Account findAccount(String accountNumber) {
		
    }
	
	public void deposit(String accountNumber, double amount) {
		
	}
	
	public void withdraw(String accountNumber, double amount) {
		
	}
	
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
		
	}
	
	public void printAllAccounts() {
		
	}
}

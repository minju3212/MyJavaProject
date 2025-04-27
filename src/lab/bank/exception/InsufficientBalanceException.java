package lab.bank.exception;

public class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String message) {
		super(message == null ? "잔액이 부족합니다." : message);
	}
}

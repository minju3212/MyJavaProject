package lab.bank.exception;

public class AccountNotFoundException extends Exception {
	public AccountNotFoundException(String message) {
		super(message == null ? "���¸� ã�� �� �����ϴ�." : message);
	}
}

package lab.bank.exception;

public class AccountNotFoundException extends Exception {
	public AccountNotFoundException(String message) {
		super(message == null ? "계좌를 찾을 수 없습니다." : message);
	}
}

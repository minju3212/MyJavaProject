package lab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException{
	public WithdrawalLimitExceededException(String message) {
		super(message == null ? "출금 한도를 초과했습니다." : message);
	}

}

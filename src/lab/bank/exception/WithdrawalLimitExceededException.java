package lab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException{
	public WithdrawalLimitExceededException(String message) {
		super(message == null ? "��� �ѵ��� �ʰ��߽��ϴ�." : message);
	}

}

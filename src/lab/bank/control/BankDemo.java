package lab.bank.control;

import lab.bank.entity.Bank;
import lab.bank.entity.CheckingAccount;
import lab.bank.entity.SavingsAccount;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount sa1 = null; // 홍길동의 저축 계좌
        CheckingAccount ca1 = null; // 김철수의 체킹 계좌
        SavingsAccount sa2 = null; // 이영희의 저축 계좌

        // 계좌 생성
        try {
            System.out.println("=== 계좌 생성 ===");
            sa1 = bank.createSavingsAccount("홍길동", 10000, 0.03);
            ca1 = bank.createCheckingAccount("김철수", 20000, 5000);
            sa2 = bank.createSavingsAccount("이영희", 30000, 0.02);
        } catch (Exception e) {
            System.out.println("계좌 생성 중 예외 발생: " + e.getMessage());
            e.printStackTrace();
        }

        // 입금/출금 테스트
        try {
            System.out.println("\n=== 입금/출금 테스트 ===");
            bank.deposit(sa1.getAccountNumber(), 5000); // 입금 (기존 계좌)
            bank.withdraw(sa1.getAccountNumber(), 3000); // 출금
        } catch (Exception e) {
            System.out.println("입출금 중 예외 발생: " + e.getMessage());
            e.printStackTrace();
        }

        // 이자 적용 테스트
        try {
            System.out.println("\n=== 이자 적용 테스트 ===");
            sa1.applyInterest(); // 기존 계좌에 이자 적용
        } catch (Exception e) {
            System.out.println("이자 적용 중 예외 발생: " + e.getMessage());
            e.printStackTrace();
        }

        // 계좌 이체 테스트
        try {
            System.out.println("\n=== 계좌 이체 테스트 ===");
            bank.transfer(sa2.getAccountNumber(), ca1.getAccountNumber(), 5000); // 송금
        } catch (Exception e) {
            System.out.println("계좌 이체 중 예외 발생: " + e.getMessage());
            e.printStackTrace();
        }
        
     // 전체 계좌 출력
        try {
            //System.out.println("\n=== 모든 계좌 목록 ===");
            bank.printAllAccounts();
        } catch (Exception e) {
            System.out.println("계좌 출력 중 예외 발생: " + e.getMessage());
            e.printStackTrace();
        }

        // 예외 테스트
        try {
            System.out.println("\n=== 예외 테스트 ===");
            bank.withdraw(ca1.getAccountNumber(), 6000); // 출금 한도 초과
            bank.findAccount("AC9999"); // 없는 계좌에 대한 조회
        } catch (Exception e) {
            System.out.println("예외 테스트 중 예외 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
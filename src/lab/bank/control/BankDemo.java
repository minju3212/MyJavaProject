package lab.bank.control;

import lab.bank.entity.Bank;
import lab.bank.entity.CheckingAccount;
import lab.bank.entity.SavingsAccount;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount sa1 = null; // ȫ�浿�� ���� ����
        CheckingAccount ca1 = null; // ��ö���� üŷ ����
        SavingsAccount sa2 = null; // �̿����� ���� ����

        // ���� ����
        try {
            System.out.println("=== ���� ���� ===");
            sa1 = bank.createSavingsAccount("ȫ�浿", 10000, 0.03);
            ca1 = bank.createCheckingAccount("��ö��", 20000, 5000);
            sa2 = bank.createSavingsAccount("�̿���", 30000, 0.02);
        } catch (Exception e) {
            System.out.println("���� ���� �� ���� �߻�: " + e.getMessage());
            e.printStackTrace();
        }

        // �Ա�/��� �׽�Ʈ
        try {
            System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
            bank.deposit(sa1.getAccountNumber(), 5000); // �Ա� (���� ����)
            bank.withdraw(sa1.getAccountNumber(), 3000); // ���
        } catch (Exception e) {
            System.out.println("����� �� ���� �߻�: " + e.getMessage());
            e.printStackTrace();
        }

        // ���� ���� �׽�Ʈ
        try {
            System.out.println("\n=== ���� ���� �׽�Ʈ ===");
            sa1.applyInterest(); // ���� ���¿� ���� ����
        } catch (Exception e) {
            System.out.println("���� ���� �� ���� �߻�: " + e.getMessage());
            e.printStackTrace();
        }

        // ���� ��ü �׽�Ʈ
        try {
            System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
            bank.transfer(sa2.getAccountNumber(), ca1.getAccountNumber(), 5000); // �۱�
        } catch (Exception e) {
            System.out.println("���� ��ü �� ���� �߻�: " + e.getMessage());
            e.printStackTrace();
        }
        
     // ��ü ���� ���
        try {
            //System.out.println("\n=== ��� ���� ��� ===");
            bank.printAllAccounts();
        } catch (Exception e) {
            System.out.println("���� ��� �� ���� �߻�: " + e.getMessage());
            e.printStackTrace();
        }

        // ���� �׽�Ʈ
        try {
            System.out.println("\n=== ���� �׽�Ʈ ===");
            bank.withdraw(ca1.getAccountNumber(), 6000); // ��� �ѵ� �ʰ�
            bank.findAccount("AC9999"); // ���� ���¿� ���� ��ȸ
        } catch (Exception e) {
            System.out.println("���� �׽�Ʈ �� ���� �߻�: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
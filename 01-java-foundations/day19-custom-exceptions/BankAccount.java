public class BankAccount {

    private int balance = 500;

    void withdraw(int amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException("Not enough balance");
        }
        balance -= amount;
        System.out.println("Withdrawal successful");
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.withdraw(1000);
    }
}


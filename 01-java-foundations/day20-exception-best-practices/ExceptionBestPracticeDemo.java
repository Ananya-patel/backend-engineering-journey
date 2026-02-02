public class ExceptionBestPracticeDemo {

    static void withdraw(int balance, int amount) {
        if (amount > balance) {
            throw new IllegalArgumentException(
                "Withdrawal amount exceeds balance"
            );
        }
        System.out.println("Withdrawal successful");
    }

    public static void main(String[] args) {
        try {
            withdraw(500, 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


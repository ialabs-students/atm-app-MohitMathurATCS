package atm;
import java.util.Scanner;

//Remember this is ATM not user account
class Atm {
    Atm() {
        start();
    }

    int balance = 0;
    int Total2000 = 0;
    int Total500 = 0;
    int Total200 = 0;
    int Total100 = 0;
    Scanner sc = new Scanner(System.in);

    void start() {
		System.out.println("Automated Teller Machine");
		System.out.println("Choose 1 for Deposit");
		System.out.println("Choose 2 for Withdraw");
		System.out.println("Choose 3 for Check Balance");
		System.out.println("Choose 4 for EXIT");
		System.out.println("->");
        byte opt = 0;
        try {
            opt = sc.nextByte();
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (opt) {
            case (1) -> depositAmount();
            case (2) -> withdrawAmount();
            case (3) -> BalanceEnquiry();
            case (4) -> System.exit(0);
            default -> {
                System.out.println("Please enter valid input");
                start();
            }
        }
    }

    void depositAmount() {
        int deposit = 0;
        System.out.print("2000 X ");
        Total2000 = sc.nextInt();
        deposit += 2000 * Total2000;

        System.out.print("500 X ");
        Total500 = sc.nextInt();
        deposit += 500 * Total500;

        System.out.print("200 X ");
        Total200 = sc.nextInt();
        deposit += 200 * Total200;

        System.out.print("100 X ");
        Total100 = sc.nextInt();
        deposit += 100 * Total100;
        balance += deposit;
        canDeposit(deposit);
        System.out.println("You have deposited " + deposit);
        BalanceEnquiry();
        start();
    }

    void withdrawAmount() {
        System.out.print("How much money you want to withdraw \nEnter in multiple of 100 -> ");
        int withdraw = sc.nextInt();
        canWithdraw(withdraw);
        balance -= withdraw;
        if (withdraw % 100 != 0) {
            System.out.println("Enter amount multiple of 100");
            start();
        }
        int count2000 = 0;
        int count500 = 0;
        int count200 = 0;
        int count100 = 0;
        while (withdraw != 0) {
            if (withdraw >= 2000 && Total2000 > 0 && Math.floor(withdraw / 2000) > 0) {
                withdraw -= 2000;
                count2000++;
                Total2000--;
            } else if (withdraw >= 500 && Total500 > 0 && Math.floor(withdraw / 500) > 0) {
                withdraw -= 500;
                count500++;
                Total500--;
            } else if (withdraw >= 200 && Total200 > 0 && Math.floor(withdraw / 200) > 0) {
                withdraw -= 200;
                count200++;
                Total200--;
            } else if (withdraw >= 100 && Total100 > 0 && Math.floor(withdraw / 100) > 0) {
                withdraw -= 100;
                count100++;
                Total100--;
            } else {
                System.out.println("This note is not available");
                balance += withdraw;
                withdraw = 0;
            }
        }
        System.out.println(count2000 + " of 2000");
        System.out.println(count500 + " of 500");
        System.out.println(count200 + " of 200");
        System.out.println(count100 + " of 100");
        BalanceEnquiry();
        start();
    }

    void BalanceEnquiry() {
        System.out.println("Total available balance is " + balance);
        start();
    }

    void canDeposit(int i) {
        if (i < 0) {
            System.out.println("Incorrect deposit amount");
            start();
        } else if (i == 0) {
            System.out.println("Deposit amount cannot be zero");
            System.out.println("Try again ! ");
            start();
        }
    }

    void canWithdraw(int j) {
        if (j <= 0) {
            System.out.println("Incorrect withdraw amount");
            start();
        } else if (j > balance) {
            System.out.println("Insufficient funds");
            System.out.println("Try again ! ");
            start();
        }
    }

}

public class ATM_Abc {
    public static void main(String[] args) {
        new Atm();
    }
}

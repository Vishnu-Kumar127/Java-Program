import java.util.Scanner;

class BankAccount 
{
    int accountId;
    String name;
    double balance;

    public BankAccount(int accountId, String name, double balance) 
    {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    public void transferTo(BankAccount receiver, double amount) 
    {
        if (amount > 0 && balance >= amount) 
        {
            balance -= amount;
            receiver.balance += amount;

            System.out.println("Transaction Details:");
            System.out.println("Account id: " + accountId);
            System.out.println("Name: " + name);
            System.out.println("Account Balance: Rs." + balance);
            System.out.println();
        } 
        else 
        {
            System.out.println("Insufficient funds for the transaction.");
        }
    }
}

public class BankTransaction 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Account A:");
        System.out.print("Account id: ");
        int accountIdA = scanner.nextInt();
        System.out.print("Name: ");
        scanner.nextLine();
        String nameA = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double balanceA = scanner.nextDouble();

        System.out.println("\nEnter details for Account B:");
        System.out.print("Account id: ");
        int accountIdB = scanner.nextInt();
        System.out.print("Name: ");
        scanner.nextLine();
        String nameB = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double balanceB = scanner.nextDouble();

        BankAccount accountA = new BankAccount(accountIdA, nameA, balanceA);
        BankAccount accountB = new BankAccount(accountIdB, nameB, balanceB);

        System.out.println("\nEnter transfer amounts:");
        System.out.print("Transfer amount from Account A to B: ");
        double transferAmountAB = scanner.nextDouble();
        System.out.println();
        
        accountA.transferTo(accountB, transferAmountAB);

        System.out.println("Enter transfer amounts:");
        System.out.print("Transfer amount from Account B to A: ");
        double transferAmountBA = scanner.nextDouble();
        System.out.println();

        accountB.transferTo(accountA, transferAmountBA);

        scanner.close();
    }
}
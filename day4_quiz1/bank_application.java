import java.util.Scanner;

interface Account 
{
    void deposit(double amount);

    void withdraw(double amount);

    double checkBalance();

    String getAccountNumber();
}

abstract class BaseAccount implements Account 
{
    private String accountNumber;
    private double balance;

    public BaseAccount(String accountNumber, double initialBalance) 
    {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } 
        else 
        {
            System.out.println("Invalid deposit amount");
        }
    }

    @Override
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }

    @Override
    public double checkBalance() 
    {
        return balance;
    }

    public String getAccountNumber() 
    {
        return accountNumber;
    }
}

class SavingsAccount extends BaseAccount 
{
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) 
    {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() 
    {
        double interest = checkBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest applied: $" + interest);
    }
}

class CheckingAccount extends BaseAccount 
{
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) 
    {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= (checkBalance() + overdraftLimit)) 
        {
            super.withdraw(amount);
            System.out.println("Overdraft used: $" + Math.max(0, amount - checkBalance()));
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount or overdraft limit exceeded");
        }
    }
}

class LoanAccount extends BaseAccount 
{
    private double interestRate;

    public LoanAccount(String accountNumber, double initialBalance, double interestRate) 
    {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() 
    {
        double interest = checkBalance() * interestRate;
        withdraw(interest);
        System.out.println("Loan interest applied: $" + interest);
    }
}

public class bank_application 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Savings Account:");
        System.out.print("Account Number: ");
        String savingsAccountNumber = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double savingsInitialBalance = scanner.nextDouble();
        System.out.print("Interest Rate: ");
        double savingsInterestRate = scanner.nextDouble();

        System.out.println("\nEnter details for Checking Account:");
        System.out.print("Account Number: ");
        scanner.nextLine();  
        String checkingAccountNumber = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double checkingInitialBalance = scanner.nextDouble();
        System.out.print("Overdraft Limit: ");
        double checkingOverdraftLimit = scanner.nextDouble();

        System.out.println("\nEnter details for Loan Account:");
        scanner.nextLine();  
        System.out.print("Account Number: ");
        String loanAccountNumber = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double loanInitialBalance = scanner.nextDouble();
        System.out.print("Interest Rate: ");
        double loanInterestRate = scanner.nextDouble();

        SavingsAccount savingsAccount = new SavingsAccount(savingsAccountNumber, savingsInitialBalance, savingsInterestRate);
        CheckingAccount checkingAccount = new CheckingAccount(checkingAccountNumber, checkingInitialBalance, checkingOverdraftLimit);
        LoanAccount loanAccount = new LoanAccount(loanAccountNumber, loanInitialBalance, loanInterestRate);

        System.out.println("\nInitial Balances:");
        displayAccountDetails(savingsAccount);
        displayAccountDetails(checkingAccount);
        displayAccountDetails(loanAccount);

        System.out.println("\nEnter transactions:");
        System.out.print("Deposit to Savings Account: ");
        double depositAmount = scanner.nextDouble();
        savingsAccount.deposit(depositAmount);

        System.out.print("Withdraw from Checking Account: ");
        double withdrawAmount = scanner.nextDouble();
        checkingAccount.withdraw(withdrawAmount);

        System.out.println("-----------------------------");
        System.out.println("\nFinal Balances:");
        displayAccountDetails(savingsAccount);
        displayAccountDetails(checkingAccount);
        displayAccountDetails(loanAccount);

        scanner.close();
    }

    private static void displayAccountDetails(Account account) 
    {
        System.out.println("-----------------------------");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: $" + account.checkBalance());
        System.out.println("-----------------------------");
    }
}
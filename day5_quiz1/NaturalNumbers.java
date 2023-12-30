
import java.util.Scanner;
public class NaturalNumbers implements Runnable 
{
    private static final Object lock = new Object();
    private static int N;
    private static int currentNumber = 1;

    private final boolean isEvenThread;

    public NaturalNumbers(boolean isEvenThread) 
    {
        this.isEvenThread = isEvenThread;
    }

    @Override
    public void run() 
    {
        while (currentNumber <= N) 
        {
            synchronized (lock) 
            {
                if ((currentNumber % 2 == 0 && isEvenThread) || (currentNumber % 2 != 0 && !isEvenThread)) {
                    System.out.print(currentNumber + " ");
                    currentNumber++;
                    lock.notify();
                } 
                else 
                {
                    try 
                    {
                        lock.wait();
                    } 
                    catch (InterruptedException e) 
                    {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of N :");
        N = scanner.nextInt();

        Thread evenThread = new Thread(new NaturalNumbers(true));
        Thread oddThread = new Thread(new NaturalNumbers(false));

        evenThread.start();
        oddThread.start();
        scanner.close();
    }
}

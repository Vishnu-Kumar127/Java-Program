import java.util.Scanner;

class MyRunnable implements Runnable 
{
    public void run() 
    {
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }
}

public class ThreadExample 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        MyRunnable myRunnable = new MyRunnable();

        System.out.print("Enter name for Thread-1: ");
        String thread1Name = scanner.nextLine();

        System.out.print("Enter name for Thread-2: ");
        String thread2Name = scanner.nextLine();

        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t1.setName(thread1Name);
        t2.setName(thread2Name);

        t1.start();
        t2.start();

        scanner.close();
    }
}
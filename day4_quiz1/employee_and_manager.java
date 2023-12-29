import java.util.Scanner;

class Member 
{
    String name;
    int age;
    String phoneNumber;
    String address;
    double salary;

    public void printSalary() 
    {
        System.out.println("Salary: " + salary);
    }
}

class Employee extends Member {
    String specialization;
}

class Manager extends Member {
    String department;
}

public class employee_and_manager 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Creating an Employee
        Employee employee = new Employee();
        System.out.println("Enter Employee details:");
        System.out.print("Name: ");
        employee.name = scanner.nextLine();
        System.out.print("Age: ");
        employee.age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Phone Number: ");
        employee.phoneNumber = scanner.nextLine();
        System.out.print("Address: ");
        employee.address = scanner.nextLine();
        System.out.print("Salary: ");
        employee.salary = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Specialization: ");
        employee.specialization = scanner.nextLine();

        Manager manager = new Manager();
        System.out.println("\nEnter Manager details:");
        System.out.print("Name: ");
        manager.name = scanner.nextLine();
        System.out.print("Age: ");
        manager.age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Phone Number: ");
        manager.phoneNumber = scanner.nextLine();
        System.out.print("Address: ");
        manager.address = scanner.nextLine();
        System.out.print("Salary: ");
        manager.salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Department: ");
        manager.department = scanner.nextLine();
        
        scanner.close();

        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + employee.name);
        System.out.println("Age: " + employee.age);
        System.out.println("Phone Number: " + employee.phoneNumber);
        System.out.println("Address: " + employee.address);
        employee.printSalary();
        System.out.println("Specialization: " + employee.specialization);

        System.out.println("\nManager Details:");
        System.out.println("Name: " + manager.name);
        System.out.println("Age: " + manager.age);
        System.out.println("Phone Number: " + manager.phoneNumber);
        System.out.println("Address: " + manager.address);
        manager.printSalary();
        System.out.println("Department: " + manager.department);
    }
}

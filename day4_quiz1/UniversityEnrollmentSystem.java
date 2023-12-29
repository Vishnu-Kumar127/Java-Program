
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person 
{
    private String name;
    private int age;

    public Person(String name, int age) 
    {
        this.name = name;
        this.age = age;
    }

    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }
}

class Student extends Person 
{
    private int studentId;
    private List<Course> completedCourses;

    public Student(String name, int age, int studentId) 
    {
        super(name, age);
        this.studentId = studentId;
        this.completedCourses = new ArrayList<>();
    }

    public int getStudentId() 
    {
        return studentId;
    }

    public void completeCourse(Course course) 
    {
        completedCourses.add(course);
    }

    public boolean hasCompletedCourse(Course course) 
    {
        return completedCourses.contains(course);
    }
}

class Professor extends Person 
{
    private String specialization;

    public Professor(String name, int age, String specialization) 
    {
        super(name, age);
        this.specialization = specialization;
    }

    public String getSpecialization() 
    {
        return specialization;
    }
}

class Course 
{
    private String courseName;
    private List<Course> prerequisites;
    private List<Student> enrolledStudents;

    public Course(String courseName) 
    {
        this.courseName = courseName;
        this.prerequisites = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public void addPrerequisite(Course prerequisite) 
    {
        prerequisites.add(prerequisite);
    }

    public void enrollStudent(Student student) 
    {
        if (hasCompletedPrerequisites(student)) 
        {
            enrolledStudents.add(student);
            System.out.println("Enrolled " + student.getName() + " in " + courseName);
        } 
        else 
        {
            System.out.println(student.getName() + " cannot be enrolled in " + courseName +" due to incomplete prerequisites.");
        }
    }

    private boolean hasCompletedPrerequisites(Student student) 
    {
        for (Course prerequisite : prerequisites) 
        {
            if (!student.hasCompletedCourse(prerequisite)) 
            {
                return false;
            }
        }
        return true;
    }

    public void displayEnrolledStudents() 
    {
        System.out.println();
        System.out.println("Enrolled Students in " + courseName + ":");
        if (enrolledStudents.isEmpty()) 
        {
            System.out.println("No students are enrolled in " + courseName);
        } 
        else 
        {
            for (Student student : enrolledStudents) 
            {
                System.out.println("Student ID: " + student.getStudentId() +"\nName: " + student.getName() + "\nAge: " + student.getAge());
                System.out.println("-----------------------------");
            }
        }
    }

    public String getCourseName() 
    {
        return courseName;
    }
}

public class UniversityEnrollmentSystem 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Number of Students: ");
        int stu = scanner.nextInt();

        Course mathCourse = new Course("Mathematics");
        Course physicsCourse = new Course("Physics");

        for (int i = 0; i < stu; i++) 
        {
            Student student1 = createStudent(scanner,i);

            System.out.println("Available Courses: ");
            System.out.println("1. Mathematics");
            System.out.println("2. Physics\n");        

            enrollStudentInCourse(scanner, student1, mathCourse);
            enrollStudentInCourse(scanner, student1, physicsCourse);
        }

        mathCourse.displayEnrolledStudents();
        physicsCourse.displayEnrolledStudents();

        scanner.close();
    }

    private static Student createStudent(Scanner scanner,int i) 
    {
        System.out.println("Enter student details:");
        if (i==0) 
        {
            scanner.nextLine();
        }
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); 

        return new Student(name, age, studentId);
    }

    private static void enrollStudentInCourse(Scanner scanner, Student student, Course course) 
    {
        System.out.println("Enroll " + student.getName() + " in " + course.getCourseName() + "? (yes/no): ");
        String userInput = scanner.nextLine().toLowerCase();

        if ("yes".equals(userInput)) 
        {
            course.enrollStudent(student);
        } 
        else if ("no".equals(userInput)) 
        {
            System.out.println(student.getName() + " is not enrolled in " + course.getCourseName());
        } 
        else 
        {
            System.out.println("Invalid input. Type 'yes' or 'no'");
            enrollStudentInCourse(scanner, student, course);
        }
    }
}
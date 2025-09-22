package com.kce.enrollment.main;

import java.util.Scanner;
import com.kce.enrollment.model.*;
import com.kce.enrollment.service.CourseService;
import com.kce.enrollment.exception.CourseException;

public class CourseEnrollmentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseService service = new CourseService();
        int choice;

        do {
            System.out.println("\n=== Course Enrollment System ===");
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. Enroll Student");
            System.out.println("4. Display Courses");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Course ID: "); 
                    int cid = sc.nextInt(); sc.nextLine();
                    System.out.print("Course Name: "); 
                    String cname = sc.nextLine();
                    System.out.print("Capacity: "); 
                    int cap = sc.nextInt();
                    System.out.print("Fee: "); 
                    double fee = sc.nextDouble();
                    service.addCourse(new Course(cid, cname, cap, fee));
                    System.out.println("Course added!");
                    break;

                case 2:
                    System.out.print("Student ID: "); 
                    int sid = sc.nextInt(); sc.nextLine();
                    System.out.print("Student Name: "); 
                    String sname = sc.nextLine();
                    System.out.print("Premium? (true/false): "); 
                    boolean premium = sc.nextBoolean();
                    if (premium) service.addStudent(new PremiumStudent(sid, sname));
                    else service.addStudent(new Student(sid, sname));
                    System.out.println("Student added!");
                    break;

                case 3:
                    System.out.print("Student ID: "); 
                    int esid = sc.nextInt();
                    System.out.print("Course ID: "); 
                    int ecid = sc.nextInt();
                    System.out.print("Payment Amount: "); 
                    double amt = sc.nextDouble();

                    Student s = service.findStudent(esid);
                    Course c = service.findCourse(ecid);
                    Payment p = new Payment(amt);

                    // Check if student exists
                    if (s == null) {
                        System.out.println("Error: Student not found!");
                        break;
                    }

                    // Check if course exists
                    if (c == null) {
                        System.out.println("Error: Course not found!");
                        break;
                    }

                    // Attempt enrollment and handle exceptions
                    try {
                        Enrollment e = service.enrollStudent(s, c, p);
                        Receipt r = new Receipt(s, c, p);
                        System.out.println("Enrollment Successful!");
                        System.out.println(r);
                    } catch (CourseException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 4:
                    service.displayCourses();
                    break;

                case 5:
                    service.displayStudents();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}

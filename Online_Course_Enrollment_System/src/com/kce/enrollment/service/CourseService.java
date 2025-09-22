package com.kce.enrollment.service;

import java.util.*;
import com.kce.enrollment.model.*;
import com.kce.enrollment.exception.CourseException;

public class CourseService {
    private List<Course> courses = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Enrollment> enrollments = new ArrayList<>();

    public void addCourse(Course c) 
    {
    	courses.add(c); 
    	}
    public void addStudent(Student s) {
    	students.add(s);
    	}

    public Student findStudent(int id) {
        for (Student s : students) if (s.getStudentId() == id) return s;
        return null;
    }

    public Course findCourse(int id) {
        for (Course c : courses) if (c.getCourseId() == id) return c;
        return null;
    }

    public Enrollment enrollStudent(Student s, Course c, Payment p) throws CourseException {
        if (s == null) throw new CourseException("Student not found!");
        if (c == null) throw new CourseException("Course not found!");

        double finalFee = s.applyDiscount(c.getFee());

        if (!c.hasSeats()) throw new CourseException("No seats available!");
        if (p.getAmount() < finalFee) throw new CourseException("Insufficient payment!");

        c.reduceCapacity();
        Enrollment e = new Enrollment(s, c);
        enrollments.add(e);
        return e;
    }

    public void displayCourses() {
        for (Course c : courses) System.out.println(c);
    }

    public void displayStudents() {
        for (Student s : students) System.out.println(s);
    }
}

package com.kce.enrollment.model;

public class Receipt {
    private Student student;
    private Course course;
    private Payment payment;

    public Receipt(Student student, Course course, Payment payment) {
        this.student = student;
        this.course = course;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "----- RECEIPT -----\n" +
               "Student: " + student.getName() + "\n" +
               "Course: " + course.getName() + "\n" +
               payment + "\n" +
               "------------------";
    }
}

package com.kce.enrollment.model;

public class Student {
    private int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId()
    { 
    	return studentId; 
    	}
    public String getName()
    {
    	return name; 
    	}

    public double applyDiscount(double fee)
    {
    	return fee; 
    	}

    @Override
    public String toString() {
        return studentId + " - " + name;
    }
}

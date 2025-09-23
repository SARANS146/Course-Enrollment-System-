package com.kce.enrollment.model;

public class Course {
    private int courseId;
    private String name;
    private int capacity;
    private double fee;
    private Instructor instructor;  // Aggregation

    public Course(int courseId, String name, int capacity, double fee, Instructor instructor) {
        this.courseId = courseId;
        this.name = name;
        this.capacity = capacity;
        this.fee = fee;
        this.instructor = instructor;
    }

    public int getCourseId() 
    {
    	return courseId;
    	}
    public String getName()
    {
    	return name;
    	}
    public int getCapacity()
    {
    	return capacity;
    	}
    public double getFee()
    {
    	return fee; 
    	}
    public Instructor getInstructor()
    {
    	return instructor; 
    	}

    public boolean hasSeats()
    {
    	return capacity > 0;
    	}
    public void reduceCapacity()
    {
    	if (capacity > 0) capacity--;
    	}

    @Override
    public String toString() {
        return courseId + " - " + name + " | Fee: " + fee + " | Seats left: " + capacity
                + " | Instructor: " + (instructor != null ? instructor.getName() : "None");
    }
}

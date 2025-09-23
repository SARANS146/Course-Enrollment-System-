package com.kce.enrollment.model;

public class PremiumStudent extends Student {
    public PremiumStudent(int studentId, String name) {
        super(studentId, name);
    }

    @Override
    public double applyDiscount(double fee) {
        return fee * 0.9; 
    }

    @Override
    public String toString() {
        return super.toString() + " (Premium)";
    }
}

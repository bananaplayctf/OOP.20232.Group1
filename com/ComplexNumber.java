package com;

public class ComplexNumber {

    private final double real;
    private final double imag;

    public ComplexNumber(double real, double imag) {
        if (Double.isInfinite(imag)){
            real = Double.POSITIVE_INFINITY;
            imag = Double.POSITIVE_INFINITY;
        }
        this.real = real;
        this.imag = imag;
    }

    // Getter methods for real and imaginary parts
    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    // Method to add complex numbers
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imag + other.imag);
    }

    // Method to subtract complex numbers
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imag - other.imag);
    }

    // Method to multiply complex numbers
    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imag * other.imag;
        double newImag = this.real * other.imag + this.imag * other.real;
        return new ComplexNumber(newReal, newImag);
    }

    // Method to divide complex numbers (handles division by zero)
    public ComplexNumber divide(ComplexNumber other) {
        if (Double.isInfinite(other.getReal()) || Double.isInfinite(other.getImag())){
            return new ComplexNumber(0, 0);
        }
        double denominator = other.real * other.real + other.imag * other.imag;
        double newReal = (this.real * other.real + this.imag * other.imag) / denominator;
        double newImag = (this.imag * other.real - this.real * other.imag) / denominator;
        return new ComplexNumber(newReal, newImag);
    }

    // Method to find the magnitude (absolute value) of the complex number
    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }

    // Method to find the argument (angle) of the complex number in radians
    public double arg() {
        return Math.atan2(imag, real);
    }

    // Method to find the conjugate of the complex number (same real part, opposite imaginary part)
    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imag);
    }

    // Override toString() method for a human-readable representation
    @Override
    public String toString() {
        return real + "  +  " + imag + "i";
    }  

    @Override
    public boolean equals(Object other){
        if (!(other instanceof ComplexNumber)){
            return false;
        }
        ComplexNumber temp = (ComplexNumber) other;
        if ((getReal() == temp.getReal()) && (getImag() == temp.getImag())){
            return true;
        }
        return false;
    }
}


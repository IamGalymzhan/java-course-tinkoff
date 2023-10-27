package edu.hw2.Task2;

public class Rectangle {
    protected int width = 0;
    protected int height = 0;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}

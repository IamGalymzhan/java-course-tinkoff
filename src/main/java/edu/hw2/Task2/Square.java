package edu.hw2.Task2;

public class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }

    public Square() {

    }

    public void setWidth(int width) {
        super.setWidth(width);
        if (this.height == 0) {
            super.setHeight(width);
        }
    }

    public void setHeight(int height) {
        super.setHeight(height);
        if (this.width == 0) {
            super.setHeight(height);
        }
    }
}

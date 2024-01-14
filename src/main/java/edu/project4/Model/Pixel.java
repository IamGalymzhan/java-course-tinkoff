package edu.project4.Model;

public class Pixel {
    int r;
    int g;
    int b;
    int hitCount;
    double normal;

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getHitCount() {
        return hitCount;
    }

    public double getNormal() {
        return normal;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public void setNormal(double normal) {
        this.normal = normal;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Pixel(int r, int g, int b, int hitCount, int normal) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.hitCount = hitCount;
        this.normal = normal;
    }

}

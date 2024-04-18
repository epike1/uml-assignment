package shapesProgram;

import java.text.DecimalFormat;

public class RightTriangle extends Shape {

    private double width;
    private double height;

    public RightTriangle() {
        super("right triangle", 3);
        this.width = 5.0;
        this.height = 5.0;
    }

    public RightTriangle(double width, double height) {
        super("right triangle", 3);
        this.width = width;
        this.height = height;
    }

    public void setWidth(double num) {
        width = num;
    }

    public void setHeight(double num) {
        height = num;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getHypotenuse() {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

    public double getPerimeter() {
        return width + height + getHypotenuse();
    }

    public double getArea() {
        return (width * height) / 2;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return super.toString() + " The area is " + df.format(getArea()) + " and the perimeter is " + df.format(getPerimeter()) + ".";
    }
}

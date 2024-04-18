package shapesProgram;

import java.text.DecimalFormat;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle() {
        super("rectangle", 4);
        this.width = 10.0;
        this.height = 5.0;
    }

    public Rectangle(double width, double height) {

        super("rectangle", 4);
        this.width = width;
        this.height = height;
    }

    public Rectangle(String shapeName, double width, double height) {
        super(shapeName, 4);
        this.width = width;
        this.height = height;
    }

    public void setWidth(double num) {
        this.width = num;
    }

    public void setHeight(double num) {
        this.height = num;
    }
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    public double getPerimeter() {
        return (2 * width) + (2 * height);
    }

    public double getArea() {
     return width * height;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return super.toString() + " The area is " + df.format(getArea()) + " and the perimeter is " + df.format(getPerimeter()) + ".";
    }
}

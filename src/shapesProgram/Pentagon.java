package shapesProgram;

import java.text.DecimalFormat;

public class Pentagon extends Shape {

    private double sideLength;

    public Pentagon() {
        super("pentagon", 5);
        this.sideLength = 5.0;
    }

    public Pentagon(double sideLength) {
        super("pentagon", 5);
        this.sideLength = sideLength;
    }

    public void setSideLength(double num) {
        this.sideLength = num;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double getPerimeter() {
        return sideLength * getSideNum();
    }

    public double getArea() {
        return 0.25 * Math.sqrt(5 * (5 + (2 * Math.sqrt(5)))) * Math.pow(sideLength, 2);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return super.toString() + " The area is " + df.format(getArea()) + " and the perimeter is " + df.format(getPerimeter()) + ".";
    }
}

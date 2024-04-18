package shapesProgram;

public class Shape {

    private final String shapeName;
    private final int sideNum;

    public Shape() {

        this.shapeName = "shape";
        this.sideNum = 4;
    }

    public Shape(String shapeName, int sideNum) {
        this.sideNum = sideNum;
        this.shapeName = shapeName;
    }

    public double getSideNum() {
        return sideNum;
    }

    public String toString() {
        return "This " + shapeName + " has " + sideNum + " sides.";
    }
}

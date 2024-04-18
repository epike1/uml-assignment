package shapesProgram;

public class Square extends Rectangle {

    public Square() {
        super("square", 5.0, 5.0);
    }

    public Square(double sideLength) {
        super("square", sideLength, sideLength);
    }
}

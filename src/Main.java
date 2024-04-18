import shapesProgram.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(); // default constructor
        Rectangle r2 = new Rectangle(15, 25);

        System.out.println(r1);
        System.out.println(r2 +"\n");

        Square s1 = new Square(); // default constructor
        Square s2 = new Square(15);

        System.out.println(s1);
        System.out.println(s2 +"\n");

        RightTriangle t1 = new RightTriangle(); // default constructor
        RightTriangle t2 = new RightTriangle(10, 15);

        System.out.println(t1);
        System.out.println(t2 + "\n");

        Pentagon p1 = new Pentagon(); // default constructor
        Pentagon p2 = new Pentagon(15);

        System.out.println(p1);
        System.out.println(p2);
    }
}
// Base class Shape
abstract class Shape {
    // Abstract method to calculate area
    abstract double calculateArea();
}

// Subclass Circle
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Override calculateArea method for Circle
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Subclass Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Override calculateArea method for Rectangle
    @Override
    double calculateArea() {
        return length * width;
    }
}

// Subclass Triangle
class Triangle extends Shape {
    private double base;
    private double height;

    // Constructor
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Override calculateArea method for Triangle
    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

// Main class to test the Shape subclasses
public class Main {
    public static void main(String[] args) {
        // Create instances of Circle, Rectangle, and Triangle
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4);

        // Calculate and print the areas
        System.out.println("Area of Circle: " + circle.calculateArea());
        System.out.println("Area of Rectangle: " + rectangle.calculateArea());
        System.out.println("Area of Triangle: " + triangle.calculateArea());
    }
}

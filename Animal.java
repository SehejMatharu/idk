// Base class Animal
abstract class Animal {
    // Abstract method to make sound
    abstract void Sound();
}

// Subclass Bird
class Bird extends Animal {
    // Override Sound method for Bird
    @Override
    void Sound() {
        System.out.println("Chirp Chirp");
    }
}

// Subclass Cat
class Cat extends Animal {
    // Override Sound method for Cat
    @Override
    void Sound() {
        System.out.println("Meow Meow");
    }
}

// Main class to test the Animal subclasses
public class Main {
    public static void main(String[] args) {
        // Create instances of Bird and Cat
        Animal bird = new Bird();
        Animal cat = new Cat();

        // Make each animal sound
        System.out.println("Bird sound:");
        bird.Sound();
        
        System.out.println("Cat sound:");
        cat.Sound();
    }
}


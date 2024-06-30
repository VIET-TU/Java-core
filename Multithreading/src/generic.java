
import java.util.ArrayList;
import java.util.List;
 
abstract class Shape {
    abstract void draw();
}
 
class Rectangle extends Shape {
    void draw() {
        System.out.println("ve hinh chu nhat.");
    }
}
 
class Circle extends Shape {
    void draw() {
        System.out.println("ve hinh tron.");
    }
}
 

/**
* Assignment: SDEV200_M03_Assignment1_Ex13_09
* File: Circle.java
* Version: 1.0
* Date: 1/31/2024
* Author: Tomomi Hobara
* Description: The Circle class defined in this program extends GeometricObject and implements the Comparable interface.
               Also, the Circle class overrides the equals method from the Object class.
               The TestNewCircle class creates two Circle objects and invokes the equals and compareTo methods.
               The results of the comparison are printed in the console.            
* Variables: 
    - obj1, 2: Circle objects
    - radius: double, holds radius value
    - color: String, superclass's data field
    - filled: boolean, superclass's data field
* Steps:
    1. Define the Circle class with constructors
    2. Define accessor and mutator methods
    3. Override methods of the superclass and the interface
    4. Test the overridden equals and compareTo methods by creating two objects
* Related file: 
    - E13_09_Circle_UML.pdf
    - GeometricObject.java: Superclass 
*/

/** Create and compare two Circle objects */
public class TestNewCircle {
    public static void main(String[] args) {
        Circle obj1 = new Circle(3);
        Circle obj2 = new Circle(5);

        System.out.println("\nThe radius of Object 1 is " + obj1.getRadius());
        System.out.println("The radius of Object 2 is " + obj2.getRadius());
        System.out.println("The objects are equal: " + obj1.equals(obj2));  // Print true or false
        // System.out.println(obj1.compareTo(obj2));
        System.out.println(obj1.compareToString(obj2)+"\n");

    }
}

/** Define the Circle class */
class Circle extends GeometricObject implements Comparable<Circle> {   
    
    private double radius;

    /** No-arg constructor */
    public Circle() {
   }
   
   /** Constructor with a specified radius */
    public Circle(double radius) {
       this.radius = radius;
    }
   
    /** Constructor with superclass's data fields */
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }
   
    /** Return radius */
    public double getRadius() {
        return radius;
   }
   
    /** Set a new radius */
    public void setRadius(double radius) {
        this.radius = radius;
    }
   
    /** Return area */
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
   }
   
    /** Return diameter */
    public double getDiameter() {
        return 2 * radius;
    }
   
    /** Return perimeter by overriding the superclass's method.*/
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
   
    /** Print the circle info */
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
            " and the radius is " + radius);
       }


    /** Override the compareTo from the Comparable interface */
    @Override
    public int compareTo(Circle obj) {
    if (this.getArea() > obj.getArea())
        return 1;
    else if (this.getArea() < obj.getArea())
            return -1;
    else
        return 0;
    }

    /** Print the result of compareTo */
    public String compareToString(Circle obj) {
        int result = this.compareTo(obj);
        
        if (result > 0) {
            return "Object 1 is larger";
        } else if (result < 0) {
            return "Object 1 is smaller";
        } else {
            return "Object1 and Object 2 are equal";
        }
    }

    /** Override the equals method from the Object class.
     *  Return true if they are equal.
     */
    @Override
    public boolean equals(Object obj) {
        return this.getArea() == ((Circle)obj).getArea();
    }

}
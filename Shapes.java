package KatasSolution;

import java.util.ArrayList;

abstract class Calculator implements Comparable<Calculator>{
    public abstract double getTotalArea();


}
class Square extends Calculator {

    private double side;
    Square(double side){
        this.side = side;
    }
    public double getTotalArea(){
        return side*side;
    }

    @Override
    public int compareTo(Calculator o) {
        return 0;
    }
}
class Rectangle extends Calculator{

    private double width,height;
    Rectangle(double width,double height){
        this.width = width;
        this.height = height;
    }
    public double getTotalArea(){
        return width*height;
    }

    @Override
    public int compareTo(Calculator o) {
        return 0;
    }
}

class Triangle extends Calculator{

    private double height,base;
    Triangle(double base,double height){
        this.base = base;
        this.height = height;
    }
    public double getTotalArea(){
        return base*height / 2;
    }

    @Override
    public int compareTo(Calculator o) {
        return 0;
    }
}
class Circl extends Calculator{
    private double radius;
    Circl(double radius){
        this.radius = radius;
    }
    public double getTotalArea(){
        return radius*radius*Math.PI;
    }

    @Override
    public int compareTo(Calculator o) {
        return 0;
    }
}

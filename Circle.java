package KatasSolution;

public class Circle {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public boolean isEqual(){
        // if i use double never come true so i used int type casting
        int alan = (int) (Math.PI * radius * radius);
        int cevre = (int) (2 * Math.PI * radius);
        if (alan == cevre) return true;
        else return false;
    }

    public double getCevre() {
        return 2 * Math.PI * radius;
    }

    public double getAlan() {
        return Math.PI * Math.PI * radius;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

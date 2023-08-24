package shape_package;

public class Rectangle implements Shape {
    private final double sideA;
    private final double sideB;

    Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

   @Override
   public double calcArea() {
       return sideA * sideB;
    }

    @Override
    public double calcPeriphery() {
        return 2* (sideA+sideB);
    }
}

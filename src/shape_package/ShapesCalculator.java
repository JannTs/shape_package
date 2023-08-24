/**
 * Задача1
 * Создать интерфейс Shape,содержащиq методы для подсчета
 * площади и периметра фигуры и классы прямоугольник и круг,
 * реализующие этот интерфейс.
 *
 * В методе main создать несколько фигур и вывести на печать
 * площадь и периметр каждой.
 * Написать метод, вычисляющий общую площадь фигур нескольких
 * видов,
 * т.е. если площадь прямоугольника = 100, круга = 50, то общая площадь 150
 *
 */
package shape_package;
import static shape_package.Utility.print_Line;
import java.util.Scanner;
public class ShapesCalculator {
    public static void main(String[] args) {
        /*Shape[] shapes = {
                new Rectangle(15, 10),
                new Circle(13),
                new Circle(7)
        };*/
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total quantity of shapes to be processed: ");
        int shapesQty = scanner.nextInt();

        Shape[] shapes = new Shape[shapesQty];
        for (int i = 0; i < shapesQty; i++) {
            System.out.print("Enter shape type (1 for Circle, 2 for Rectangle): ");
            int shapeType = scanner.nextInt();
            print_Line(60);
            switch (shapeType) {
                case 1:
                    System.out.print("Enter the circle's radius: ");
                    double radius = scanner.nextInt();
                    shapes[i] = new Circle(radius);
                    break;
                case 2:
                    System.out.print("Enter the length of the rectangle's side A: ");
                    double sideA = scanner.nextInt();
                    System.out.print("Enter the length of the rectangle's side B: ");
                    double sideB = scanner.nextInt();
                    shapes[i] = new Rectangle(sideA, sideB);
                    break;
                default:
                    System.out.println("Invalid shape type. Please enter 1 for Circle or 2 for Rectangle.");
                    i--; // Decrement to re-ask for this iteration
                    break;
            }
        }

        int shapesCounter = 1;
        print_Line(60);
        System.out.printf("| %-30s | %-10s | %-10s |\n", "Shape", "Area", "Perimeter");
        print_Line(60);
        for (Shape shape : shapes) {

            System.out.printf("| %-30s | %10.2f | %10.2f |\n",
                    shape.getClass().getSimpleName()+" (#"+shapesCounter+")",
                    shape.calcArea(),
                    shape.calcPeriphery());

                    shapesCounter++;
        }
        print_Line(60);

        double totalArea = calcSumOfAreas(shapes);
        System.out.printf("| %-30s | %10.2f |\n", "The sum of all figures areas", totalArea);
        print_Line(60);
    }

    public static double calcSumOfAreas(Shape[] shapes) {
        double sumOfAreas = 0;
        for (Shape shape : shapes) {
            sumOfAreas += shape.calcArea();
        }
        return sumOfAreas;
    }
}

package shape_package;

public class Utility {
    public static void print_Line(int length) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < length; i++) {
            line.append("-");
        }
        System.out.println(line);
    }
}

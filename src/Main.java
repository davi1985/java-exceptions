import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        method1();
        System.out.println("End of program...");
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        Scanner scanner = new Scanner(System.in);

        try {
            String[] text = scanner.nextLine().split(" ");
            int position = scanner.nextInt();
            System.out.println(text[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid position!");
            e.printStackTrace();

            scanner.next();
        } catch (InputMismatchException e) {
            System.out.println("Input error!");
        } finally {
            scanner.close();
        }
    }
}
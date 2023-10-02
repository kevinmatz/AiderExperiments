import java.util.Scanner;

public class Junk {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first integer:");
        int num1 = scanner.nextInt();

        System.out.println("Enter the second integer:");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;

        System.out.println("The sum of the two integers is: " + sum);
    }

}

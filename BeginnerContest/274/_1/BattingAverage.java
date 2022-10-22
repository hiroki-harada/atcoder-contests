import java.util.Scanner;

public class BattingAverage {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        System.out.println((String.format("%.3f", 1.0 * b / a)));
    }
}
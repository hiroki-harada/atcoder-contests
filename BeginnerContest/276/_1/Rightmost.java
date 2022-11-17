import java.util.Scanner;

public class Rightmost {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            System.out.println("x".concat(sc.next()).lastIndexOf("a"));
        }
    }
}
import java.util.*;

class Product {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        if ((a * b)%2 == 1) System.out.println("Odd");
        else System.out.println("Even");
    }
}
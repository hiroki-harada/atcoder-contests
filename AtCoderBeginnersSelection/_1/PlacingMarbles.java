import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        sc.close();

        if (input == 0) System.out.println(0);
        else if (input%3 == 0) System.out.println(3);
        else System.out.println(input%3);
    }
}
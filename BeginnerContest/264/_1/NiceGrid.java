import java.util.Scanner;

public class NiceGrid {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        if (r == 1 || r == 15) {
            System.out.println("black");

        } else if (r == 2 || r == 14) {
            if (c == 1 || c == 15) System.out.println("black");
            else System.out.println("white");

        } else if (r == 3 || r == 13) {
            if (c == 2 || c == 14) System.out.println("white");
            else System.out.println("black");

        } else if (r == 4 || r == 12) {
            if (c == 1 || c == 3 || c == 13 || c == 15) System.out.println("black");
            else System.out.println("white");

        } else if (r == 5 || r == 11) {
            if (c == 2 || c == 4 || c == 12 || c == 14) System.out.println("white");
            else System.out.println("black");

        } else if (r == 6 || r == 10) {
            if (c == 1 || c == 3 || c == 5 || c == 11 || c == 13 || c == 15) System.out.println("black");
            else System.out.println("white");

        } else if (r == 7 || r == 9) {
            if (c == 2 || c == 4 || c == 6 || c == 10 || c == 12 || c == 14) System.out.println("white");
            else System.out.println("black");

        } else if (r == 8) {
            if (c == 2 || c == 4 || c == 6 || c == 8 || c == 10 || c == 12 || c == 14) System.out.println("white");
            else System.out.println("black");
        }
    }
}
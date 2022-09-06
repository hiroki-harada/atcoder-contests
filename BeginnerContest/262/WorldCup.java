import java.util.Scanner;

public class WorldCup {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int currentYear = sc.nextInt();
        sc.close();

        if (currentYear%4 == 0) System.out.println(currentYear + 2);
        else if (currentYear%4 == 1) System.out.println(currentYear + 1);
        else if (currentYear%4 == 2) System.out.println(currentYear);
        else if (currentYear%4 == 3) System.out.println(currentYear + 3);
    }
}
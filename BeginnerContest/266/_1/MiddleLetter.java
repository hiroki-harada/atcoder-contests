import java.util.Scanner;

public class MiddleLetter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        System.out.println(s.substring(s.length()/2, s.length()/2 + 1));
    }
}
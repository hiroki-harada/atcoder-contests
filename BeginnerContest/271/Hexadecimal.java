import java.util.Scanner;

public class Hexadecimal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        String hex = Integer.toHexString(n).toUpperCase();
        hex = hex.length() == 1 ? "0" + hex : hex; 
        System.out.println(hex);

    }
}
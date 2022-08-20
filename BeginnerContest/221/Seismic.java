import java.util.*;

class Seismic {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        System.out.println((int)Math.pow(32, a-b));
    }
}
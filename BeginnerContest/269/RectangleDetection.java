import java.util.Scanner;

public class RectangleDetection {
    public static void main(String[] args) {

        int n = 10;
        String[] s = new String[n + 1];
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 1; i <= n; i++) {
            if (a == 0 && s[i].indexOf("#") != -1) {
                a = i;
                c = s[i].indexOf("#") + 1;
                d = s[i].lastIndexOf("#") + 1;
            }
            
            if (a != 0 && s[i].indexOf("#") != -1) {
                b = i;
            }
        }
        System.out.println(a + " " + b);
        System.out.println(c + " " + d);
    }
}
import java.util.*;

public class TShirts {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        in.nextInt(); // discard n
        int m = in.nextInt();
        String s = in.nextStr();
        in.close();

        int mujiT = m;
        int logoT = 0;
        int result = 0;
        for (char day : s.toCharArray()) {
            if (day == '0') {
                mujiT = m;
                logoT = result;
            }
            if (day == '1') {
                if (mujiT > 0) mujiT--;
                else if (logoT > 0) logoT--;
                else result++;
            }
            if (day == '2') {
                if (logoT > 0) logoT--;
                else result++;
            }
        }

        System.out.println(result);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
    }
}
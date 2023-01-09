import java.util.*;

public class HappyNewYear {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();

        int t = io.nextInt();
        while (t-- > 0) {
            long n = io.nextLong();
            long p = 0;
            long q = 0;

            // min(p,q) <= ∛N が成り立つ
            // √N まで試し割りしなくても、∛N まで試し割りすれば、p, q のいずれかが求まる
            for (int i = 2; i*i*i <= n; i++) {
                if (n%i != 0) continue;
                if ((n/i) % i == 0) {
                    p = i;
                    q = n/i/i;
                } else {
                    p = (long)Math.round(Math.sqrt(1d*n/i));
                    q = i;
                }
                break;
            }
            io.output(p + " " + q);

        }
        io.close();
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private <T> void output(T result) {System.out.println(result);}
    }
}
import java.util.*;

public class ImpartialGift {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        long d = io.nextLong();
        List<Long> a = new ArrayList<>();
        List<Long> b = new ArrayList<>();
        for (int i = 0; i < n; i++) a.add(io.nextLong());
        for (int i = 0; i < m; i++) b.add(io.nextLong());
        io.close();

        Collections.sort(a);
        Collections.sort(b);

        while (true) {
            if (n == 0 || m == 0) {
                io.output(-1);
                return;
            }

            long aMax = a.get(a.size()-1);
            long bMax = b.get(b.size()-1);
            if (Math.abs(aMax-bMax) <= d) {
                io.output(aMax + bMax);
                return;
            }

            if (aMax > bMax) {
                a.remove(a.size()-1);
                n--;
            } else {
                b.remove(b.size()-1);
                m--;
            }
        }
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private void output(long result) {System.out.println(result);}
    }
}
import java.util.*;

public class Cutoff {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int x = io.nextInt();
        List<Integer> a = io.nextIntList(n-1);
        io.close();

        // an = 0~100 の全パターンについて試行する
        for (int an = 0; an <= 100; an++) {
            List<Integer> b = new ArrayList<>(a);
            b.add(an);
            Collections.sort(b);
            int sum = 0;
            for (int i = 1; i < n-1; i++) sum += b.get(i);

            if (sum >= x) {
                io.output(an);
                return;
            }
        }

        io.output(-1);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private List<Integer> nextIntList(int size) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.nextInt());
            return list;
        }
        private void output(int result) {System.out.println(result);}
    }
}
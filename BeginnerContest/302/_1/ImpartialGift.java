import java.util.*;
import java.util.stream.Collectors;

public class ImpartialGift {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        long d = io.nextLong();
        Set<Long> a = new HashSet<>();
        Set<Long> b = new HashSet<>();
        for (int i = 0; i < n; i++) a.add(io.nextLong());
        for (int i = 0; i < m; i++) b.add(io.nextLong());
        io.close();

        LinkedList<Long> s = new LinkedList<>(toSortList(a));
        LinkedList<Long> t = new LinkedList<>(toSortList(b));

        while (true) {
            if (n == 0 || m == 0) {
                io.output(-1);
                return;
            }

            long sMax = s.getLast();
            long tMax = t.getLast();
            if (Math.abs(sMax-tMax) <= d) {
                io.output(sMax + tMax);
                return;
            }

            if (sMax > tMax) {
                s.removeLast();
                n--;
            } else {
                t.removeLast();
                m--;
            }
        }
    }

    private static <T> List<T> toSortList(Set<T> set) {
        return set.stream().collect(Collectors.toList()).stream().sorted().collect(Collectors.toList());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private void output(long result) {System.out.println(result);}
    }
}
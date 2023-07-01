import java.util.*;

public class DefaultPrice {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        String[] c = io.nextStrArray(n);
        String[] d = io.nextStrArray(m);
        int p0 = io.nextInt();
        int[] p = io.nextIntArray(m);
        io.close();

        Map<String, Integer> mapPrice = new HashMap<>();
        for (int i = 0; i < m; i++) mapPrice.put(d[i], p[i]);

        int result = 0;
        for (int i = 0; i < n; i++) result += mapPrice.getOrDefault(c[i], p0);

        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
        private void output(int result) {System.out.println(result);}
    }
}
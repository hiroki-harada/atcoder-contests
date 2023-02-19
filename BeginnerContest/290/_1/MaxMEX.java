import java.util.*;
// import java.util.stream.Collectors;

public class MaxMEX {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int k = io.nextInt();

        // B は連続した数列のため、重複する値は不要
        // A を取得する時点で削除しておく
        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < n; i++) a.add(io.nextInt());
        io.close();

        // Set は順序付けされたCollectionではない？ので、sorted() による安定性は保証されない
        // List<Long> b = a.stream().sorted().limit(k).collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            if (!a.contains(i)) {
                io.output(i);
                return;
            }
        }
        io.output(k);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}
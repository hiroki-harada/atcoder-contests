import java.util.*;

public class CircularPlaylist {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        long t = io.nextLong();
        long[] a = io.nextLongArray(n);
        io.close();

        // プレイリスト全体の長さ > t となるまで、t から プレイリスト全体の長さを引く
        // > プレイリストを1回再生して、どの曲が流れているかが、答えになる
        // > ただし、t -= aTotal とすると処理に時間がかかるので、余りを求める方法を取る
        long aTotal = Arrays.stream(a).reduce(0l, (ai, aj) -> ai + aj);
        if (t > aTotal) t %= aTotal;

        for (int i = 0; i < n; i++) {
            if (t < a[i]) {
                io.output((i+1) + " " + t);
                return;
            }
            t -= a[i];
        }
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private long nextLong() {return this.sc.nextLong();}

        private long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }

        private <T> void output(T result) {System.out.println(result);}
    }
}
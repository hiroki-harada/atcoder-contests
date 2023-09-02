import java.util.*;

public class OverlappingSheets {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = io.nextInt();
            b[i] = io.nextInt();
            c[i] = io.nextInt();
            d[i] = io.nextInt();
        }
        io.close();

        Set<Integer> cntResultSet = new HashSet<>();

        // 各シートが覆うセルに一意に番号を割り振り、全シートの番号をdistinctに集約する
        // ここで、(x1, y1)-(x1+1, y1+1)を覆うセルの番号を、x1+y1*1000 と定義する
        for (int i = 0; i < n; i++) {

            Set<Integer> sellSet = new HashSet<>();
            for (int x = a[i]; x < b[i]; x++) {
                for (int y = c[i]; y < d[i]; y++) {
                    int num = x + y*1000;
                    // System.out.println(num);
                    sellSet.add(num);
                }
            }

            cntResultSet.addAll(sellSet);
        }

        io.output(cntResultSet.size());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}
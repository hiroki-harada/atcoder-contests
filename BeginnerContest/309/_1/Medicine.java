import java.util.*;

public class Medicine {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int k = io.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = io.nextInt();
            b[i] = io.nextInt();
        }
        io.close();

        // 服用期間と錠剤数/回をマッピング
        // 服用期間が重複している薬は、錠剤数をまとめる
        TreeMap<Integer, Long> mapMedicine = new TreeMap<>();
        for (int i = 0; i < n; i++) mapMedicine.put(a[i], mapMedicine.getOrDefault(a[i], 0l) + b[i]);

        // 総服用数
        long sum = mapMedicine.values().stream().reduce(0l, (i, j) -> i + j);

        int result = 0;
        for (var key : mapMedicine.keySet()) {

            if (sum <= k) {
                // i 番目に少ない薬の服用期間の翌日 = 求める日数
                io.output(result+1);
                return;
            }

            // i 番目に少ない薬を飲み終わる
            sum -= mapMedicine.get(key);
            result = key;
        }
        io.output(result+1);
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}
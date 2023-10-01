import java.util.*;
import java.util.stream.Collectors;

public class Centers {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        var a = io.nextIntArray(3*n);
        io.close();

        // key:= Ai 数列の各値(1~N)、value:= i 数列のindexのリスト
        var mapCntValue = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < 3*n; i++) {
            mapCntValue.computeIfAbsent(a[i], key -> new ArrayList<>()).add(i);
        }

        // key := Ai 数列の各値(1~N), value := f(Ai) Ai の真ん中の添え字
        var mapMiddleIndex = new HashMap<Integer, Integer>();
        for (var cntValue : mapCntValue.entrySet()) {
            var listIndex = cntValue.getValue();
            // Ai は3回だけ登場するため、Aiの中央のindexは、必ず 1 になる
            mapMiddleIndex.put(cntValue.getKey(), listIndex.get(1));
        }

        // 真ん中の添え字の昇順でソートして、数列の値を " " 区切りで出力する
        String result = mapMiddleIndex.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .map(e -> e.getKey().toString())
            .collect(Collectors.joining(" "));

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
        private <T> void output(T result) {System.out.println(result);}
    }
}
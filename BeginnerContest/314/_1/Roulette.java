import java.util.*;
import java.util.stream.Collectors;

public class Roulette {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();

        // キーを人の番号、バリューを掛けた目のリストとするMapを作成
        Map<Integer, List<Integer>> betMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int ci = io.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < ci; j++) list.add(io.nextInt());
            betMap.put(i, list);
        }
        int x = io.nextInt();
        io.close();

        // x に賭けた人の、最小の賭け数を取得
        Optional<Integer> minCount = betMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .filter(e -> e.getValue().contains(x))
            .map(e -> e.getValue().size())
            .min((i, j) -> i.compareTo(j));

        if (!minCount.isPresent()) {
            io.output(0);
            io.output("");
            return;
        }

        // 最小の賭け数で、x に賭けた人を抽出
        List<Integer> corrector = betMap.entrySet().stream()
            .filter(e -> e.getValue().contains(x) && e.getValue().size() == minCount.get())
            .map(e -> e.getKey()+1)
            .sorted()
            .collect(Collectors.toList());

        // 答えを出力
        io.output(corrector.size());
        io.outputList(corrector, " ");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
        private <T> void output(T result) {System.out.println(result);}
        private <T> void outputList(List<T> list, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (T e : list)  result.append(e).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}
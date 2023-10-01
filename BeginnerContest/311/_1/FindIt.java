import java.util.*;

public class FindIt {

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] a = io.nextIntArray(n);
        io.close();

        LinkedList<Integer> roop = new LinkedList<>();
        boolean[] isVisited = new boolean[n+1];

        // 適当な点からスタート
        int current = 1;
        while (!isVisited[current]) {
            // current を起点とする適当な点を、次点とする
            roop.add(current);
            isVisited[current] = true;
            current = a[current-1];
        }

        // 既出の点の次から末尾の点までを答えのリストに設定
        // a -> b -> c -> d -> (b)
        // b, c, d を取り出す
        List<Integer> result = new ArrayList<>();
        for (int i = roop.indexOf(current), size = roop.size(); i < size; i++) {
            result.add(roop.get(i));
        }

        io.output(result.size());
        io.outputList(result, " ");
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
        private void output(int result) {System.out.println(result);}
        private <T> void outputList(List<T> list, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (T e : list)  result.append(e).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}
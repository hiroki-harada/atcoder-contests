import java.util.*;

public class ChineseCharactor {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        List<Integer> a = io.nextIntList(m);
        io.close();

        List<Integer> result = new ArrayList<>();
        int minUnchecked = 1;
        while (minUnchecked <= n) {
            int r = minUnchecked;
            while (a.contains(r)) r++;
            for (int i = r; i >= minUnchecked; i--) result.add(i);
            minUnchecked = ++r;
        }
        io.outputArray(result.toArray(new Integer[result.size()]), " ");
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
        private <T> void outputArray(T[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}
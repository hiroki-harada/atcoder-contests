import java.util.*;

public class Deck {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int q = io.nextInt();
        int[] t = new int[q];
        long[] x = new long[q];
        for (int i = 0; i < q; i++) {
            t[i] = io.nextInt();
            x[i] = io.nextLong();
        }
        io.close();

        List<Long> result = new ArrayList<>();
        LinkedList<Long> deck = new LinkedList<>();
        for (int i = 0; i < q; i++) {
            if (t[i] == 1) deck.addFirst(x[i]);
            if (t[i] == 2) deck.addLast(x[i]);
            if (t[i] == 3) result.add(deck.get( (int)(x[i]) - 1) );
        }

        io.outputList(result, "\n");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private <T> void outputList(List<T> list, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (T e : list) result.append(e).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}
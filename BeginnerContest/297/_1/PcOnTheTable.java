import java.util.*;

public class PcOnTheTable {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int h = io.nextInt();
        // discard w
        io.nextInt();
        String[] s = io.nextStrArray(h);
        io.close();

        for (int i = 0; i < h; i++) {
            s[i] = s[i].replaceAll("TT", "PC");
        }

        io.outputArray(s, "\n");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
        private <T> void outputArray(T[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}
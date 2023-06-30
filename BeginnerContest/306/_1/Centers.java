import java.util.*;

public class Centers {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        var a = io.nextIntArray(3*n);
        io.close();

        var mapCntValue = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < 3*n; i++) {
            if (!mapCntValue.containsKey(a[i])) mapCntValue.put(a[i], new ArrayList<Integer>());



        }

        // key := A, value := f(A)
        var result = new HashMap<Integer, Integer>();
        for (var cntValue : mapCntValue.entrySet()) {
            var listIndex = cntValue.getValue();
            result.put(cntValue.getKey(), listIndex.get(listIndex.size()/2 +1));
        }

        io.output(
            result.entrySet().stream()
                .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .map(e -> e.getKey().toString())
                .reduce("", (str1, str2) -> str1 + " " + str2)
        );
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
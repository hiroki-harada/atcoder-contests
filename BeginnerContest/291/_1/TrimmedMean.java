import java.util.*;
import java.util.stream.Collectors;

public class TrimmedMean {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        List<Integer> x = io.nextList(5*n);
        io.close();

        x = x.stream().sorted().collect(Collectors.toList());
        double result = 0;
        for (int i = n; i < 4*n; i++) {
            result += x.get(i);
        }
        io.output(String.format("%.5f", result/(n*3d)));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private List<Integer> nextList(int size) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.nextInt());
            return list;
        }
        private <T> void output(T result) {System.out.println(result);}
    }
}
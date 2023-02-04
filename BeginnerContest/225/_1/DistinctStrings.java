import java.util.*;

public class DistinctStrings {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        List<String> sList = Arrays.asList(io.nextStr().split(""));
        Set<String> sSet = new HashSet<>(sList);
        io.close();

        io.output(MathUtils.factorial(sList.size()) / MathUtils.factorial(sList.size()-sSet.size()+1));
    }

    private static class MathUtils {
        private static long factorial(int n) {
            if (n == 0 || n == 1) return 1;
            return n * factorial(n-1);
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private String nextStr() {return this.sc.next();}

        private <T> void output(T result) {System.out.println(result);}
    }
}
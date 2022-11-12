import java.util.*;

public class PlayingCardsValidation {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        final int n = io.nextInt();
        List<String> s = new ArrayList<>();
        for (int i = 0; i < n; i++) s.add(io.nextStr());
        io.close();

        if ((new HashSet<>(s)).size() != n) {
            io.output("No");
            return;
        }

        for (int i = 0; i < n; i++) {
            String si = s.get(i);
            boolean isMatchFirstChar  = Arrays.asList('H', 'D', 'C', 'S').contains(si.charAt(0));
            boolean isMatchSecondChar  = Arrays.asList('A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K').contains(si.charAt(1));
            if (!isMatchFirstChar || !isMatchSecondChar) {
                io.output("No");
                return;
            }
        }
        io.output("Yes");
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private String nextStr() {return this.sc.next();}

        private <T> void output(T result) {System.out.println(result);}

    }
}
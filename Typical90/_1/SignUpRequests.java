import java.util.*;

public class SignUpRequests {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        Set<String> registUsers = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (int iDay = 1; iDay <= n; iDay++) {
            String si = io.nextStr();
            if (si.matches("[a-z0-9]{1,15}") && registUsers.add(si)) result.append(iDay).append("\n");
        }
        io.close();
        io.output(result.toString());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private String nextStr() {return this.sc.next();}

        private <T> void output(T result) {System.out.println(result);}
    }
}
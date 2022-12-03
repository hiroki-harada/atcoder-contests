import java.util.*;

public class PawnOnAGrid {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int h = io.nextInt();
        int w = io.nextInt();

        long result = 0;
        for (int i = 0; i < h; i++) {
            result += Arrays.asList(io.nextStr().split("")).stream().filter(sij -> sij.equals("#")).count();
        }
        io.close();
        io.output(result);
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private String nextStr() {return this.sc.next();}

        private void output(long result) {System.out.println(result);}
    }
}
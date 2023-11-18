import java.util.*;

public class Spread {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        String s = in.nextStr();
        in.close();

        System.out.println(
            Arrays.stream(s.split("")).map(str -> str+" ").reduce("", (str1, str2) -> str1+str2)
        );
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class Pentagon {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        String s = in.nextStr();
        String t = in.nextStr();
        in.close();

        // 線分の長さは1 or 2 & パターン数が少ない
        // > 1のみ列挙して、それ以外は2として判定する
        Map<String, Integer> mapNextPoint = Map.of(
            "AB", 1,
            "BC", 1,
            "CD", 1,
            "DE", 1,
            "AE", 1
        );

        s = Arrays.stream(s.split("")).sorted().collect(Collectors.joining());
        t = Arrays.stream(t.split("")).sorted().collect(Collectors.joining());

        System.out.println(mapNextPoint.get(s) == mapNextPoint.get(t) ? "Yes" : "No");
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
    }
}
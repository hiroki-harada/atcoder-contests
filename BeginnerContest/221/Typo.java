import java.util.*;

class Typo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        sc.close();

        if (s.equals(t)) { System.out.println("Yes"); return; }

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                t = t.substring(0, i) + t.charAt(i+1) + t.charAt(i) + t.substring(i+2);
                break;
            }
        }

        System.out.println(s.equals(t) ? "Yes" : "No");
    }
}
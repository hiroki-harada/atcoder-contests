import java.util.Scanner;

public class TournamentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
                input[i] = sc.next();
        }
        sc.close();
        
        for (int i = 0; i < n; i++) {
            if (input[i].charAt(i) != '-') {
                System.out.println("incorrect");
                return;
            }
            
            for (int j = i + 1; j < n; j++) {
                if ((input[i].charAt(j) == 'W' && input[j].charAt(i) != 'L')
                || (input[i].charAt(j) == 'L' && input[j].charAt(i) != 'W')
                || (input[i].charAt(j) == 'D' && input[j].charAt(i) != 'D')) {
                        System.out.println("incorrect");
                        return;
                    }
            }
        }
        System.out.println("correct");
    }
}
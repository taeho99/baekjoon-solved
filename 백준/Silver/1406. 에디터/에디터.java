import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (char c : str.toCharArray()) {
            left.push(c);
        }
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] split = br.readLine().split(" ");
            if (split[0].equals("L")) {
                if(!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (split[0].equals("D")) {
                if(!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (split[0].equals("B")) {
                if(!left.isEmpty()) {
                    left.pop();
                }
            } else if (split[0].equals("P")) {
                left.push(split[1].charAt(0));
            }
        }
        StringBuilder sbLeft = new StringBuilder();
        while(!left.isEmpty()) {
            sbLeft.append(left.pop());
        }
        StringBuilder sbRight = new StringBuilder();
        while(!right.isEmpty()) {
            sbRight.append(right.pop());
        }
        System.out.print(sbLeft.reverse().toString() + sbRight);
    }
}

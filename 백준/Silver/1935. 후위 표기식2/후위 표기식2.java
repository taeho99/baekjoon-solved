import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        String expr = input.next();
        Stack<Double> s = new Stack<>();
        int[] arr = new int[n];


        for(int i=0; i<n; i++) {
            arr[i] = input.nextInt();
        }

        for(int i=0; i<expr.length(); i++) {
            if (expr.charAt(i) >= 'A' && expr.charAt(i) <= 'Z') {
                s.push((double) arr[expr.charAt(i) - 'A']);
            } else {
                double n1 = s.pop();
                double n2 = s.pop();
                switch(expr.charAt(i)) {
                    case '+':
                        s.push(n2 + n1);
                        break;
                    case '-':
                        s.push(n2 - n1);
                        break;
                    case '*':
                        s.push(n2 * n1);
                        break;
                    case '/':
                        s.push(n2 / n1);
                        break;
                    default:
                        break;
                }
            }

        }
        System.out.printf("%.2f", s.pop());

    }
}
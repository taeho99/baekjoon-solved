import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = input.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = input.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1; //1부터 시작하는 자연수

        for(int i=0; i<n; i++) {
             if (a[i] >= num) {
                while(a[i] >= num) {
                    stack.push(num++);
                    sb.append('+').append('\n');
                }
                stack.pop();
                sb.append('-').append('\n');
             } else {
                int b = stack.pop();
                if (b > a[i]) {
                    System.out.println("NO");
                    return;
                } else {
                    sb.append('-').append('\n');
                }
             }
        }
        System.out.println(sb);
    }
}

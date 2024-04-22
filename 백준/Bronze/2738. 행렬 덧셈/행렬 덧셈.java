import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<2; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    arr[j][k] += input.nextInt();
                    if(i == 1) sb.append(arr[j][k]).append(" ");
                }
                if(i == 1) sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}

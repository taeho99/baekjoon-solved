import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<Math.min(n, m)/2; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=i; j<m - i; j++)
                list.add(matrix[i][j]);
            for(int j=i+1; j<n-i-1; j++) {
                list.add(matrix[j][m-i-1]);
            }
            for(int j=m-i-1; j>=i; j--) {
                list.add(matrix[n-i-1][j]);
            }
            for(int j=n-i-2; j>=i+1; j--) {
                list.add(matrix[j][i]);
            }
            Collections.rotate(list, -1*r);
            for(int j=i; j<m-i; j++) {
                matrix[i][j] = list.remove(0);
            }
            for(int j=i+1; j<n-i-1; j++) {
                matrix[j][m-i-1] = list.remove(0);
            }
            for(int j=m-i-1; j>=i; j--) {
                matrix[n-i-1][j] = list.remove(0);
            }
            for(int j=n-i-2; j>i; j--) {
                matrix[j][i] = list.remove(0);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(matrix[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

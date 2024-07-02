import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int t=1; t<=testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arrA = new int[n];
            int[] arrB = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            if(n>m) {
                int tmp = n;
                n = m;
                m = tmp;
                int[] tmpArr = arrA;
                arrA = arrB;
                arrB = tmpArr;
            }

            int result = Integer.MIN_VALUE;
            for(int i=0; i<=m-n; i++) {
                int sum = 0;
                for(int j=0; j<n; j++) {
                    sum += arrA[j]*arrB[j+i];
                }
                result = Math.max(result, sum);
            }
            System.out.println("#" + t + " " + result);
        }
    }
}

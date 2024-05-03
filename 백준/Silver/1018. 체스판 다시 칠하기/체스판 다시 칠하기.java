import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        for(int i=0; i<n; i++) {
            String tmp = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=n-8; i++) {
            for(int j=0; j<=m-8; j++) {
                int sum1 = 0, sum2 = 0;
                for(int a=0; a<8; a++) {
                    for(int b=0; b<8; b++) {
                        if(a%2 == 0) {
                            if(b%2 == 0) {
                                if(arr[a+i][b+j] != 'W')
                                    sum1++;
                                else
                                    sum2++;
                            } else {
                                if(arr[a+i][b+j] != 'B')
                                    sum1++;
                                else
                                    sum2++;
                            }
                        } else {
                            if(b%2 == 0) {
                                if(arr[a+i][b+j] != 'B')
                                    sum1++;
                                else
                                    sum2++;
                            } else {
                                if(arr[a+i][b+j] != 'W')
                                    sum1++;
                                else
                                    sum2++;
                            }
                        }
                    }
                }
                min = Math.min(min, Math.min(sum1, sum2));
            }
        }
        System.out.println(min);
    }
}

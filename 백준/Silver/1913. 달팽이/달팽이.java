import java.util.Scanner;

public class Main {
    static int count = 1;
    static int[][] arr;
                      //북 동 남 서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ny, nx;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = input.nextInt();
        int m = input.nextInt();
        arr = new int[n][n];
        ny = n/2;
        nx = n/2;
        for(int i=0; i<=(n-1)*2; i++) { //1~12
            for(int j=1; j<=i/2+1; j++) {
                arr[ny][nx] = count++;
                ny += dy[i%4];
                nx += dx[i%4];
            }
        }
        int resultY = 0, resultX = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(m == arr[i][j]) {
                    resultY = i+1;
                    resultX = j+1;
                }
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        sb.append(resultY).append(' ').append(resultX);
        System.out.println(sb);
    }
}

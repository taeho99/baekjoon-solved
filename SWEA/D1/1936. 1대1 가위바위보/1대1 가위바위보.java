import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a == 1) {
            if(b == 2) {
                System.out.print("B");
            } else {
                System.out.print("A");
            }
        } else if(a == 2) {
            if(b == 1) {
                System.out.print("A");
            } else {
                System.out.print("B");
            }
        } else {
            if(b == 1) {
                System.out.print("B");
            } else {
                System.out.print("A");
            }
        }
    }
}

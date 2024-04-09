import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for(int i=0; i<5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            if(arr[0] == 1 && arr[1] == 2 && arr[2] == 3 && arr[3] == 4 && arr[4] == 5) {
                break;
            }
            for(int i=0; i<4; i++) {
                if(arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    print(arr);
                }
            }
        }
    }
    static void print(int[] arr) {
        for(int i=0; i<5; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

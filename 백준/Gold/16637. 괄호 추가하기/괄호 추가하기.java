import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int answer = Integer.MIN_VALUE;
    static List<Integer> nums = new ArrayList<>();
    static List<Character> ops = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        String tmp = br.readLine();
        for(int idx=0; idx<size; idx++) {
            if(idx%2 == 0) nums.add(tmp.charAt(idx) - '0');
            else ops.add(tmp.charAt(idx));
        }

        dfs(0, nums.get(0));
        System.out.println(answer);
    }

    private static void dfs(int opIdx, int result) {
        if(opIdx == ops.size()) {
            answer = Math.max(answer, result);
            return;
        }

        int tmp = calc(result, nums.get(opIdx+1), ops.get(opIdx));
        dfs(opIdx + 1, tmp);

        if(opIdx + 1 < ops.size()) {
            tmp = calc(nums.get(opIdx + 1), nums.get(opIdx + 2), ops.get(opIdx + 1));
            dfs(opIdx + 2, calc(result, tmp, ops.get(opIdx)));
        }

    }

    private static int calc(int num1, int num2, char op) {
        switch(op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return 0;
    }
}

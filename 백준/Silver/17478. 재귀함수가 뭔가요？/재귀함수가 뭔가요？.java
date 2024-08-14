import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ.17478 재귀함수가 뭔가요?
 * 0. 출력 예시를 참고해 N을 입력받고 동일한 문자열을 언더바(_)를 추가해 N번 반복 출력한다.
 * 
 * 1. 처음 1번만 출력되는 문자열이 무엇인지 파악한다.
 * 2. 재귀함수로 반복되는 부분이 무엇인지 파악한다.
 * 2-1. 한 번 반복할 때마다 문자열 앞에 언더바(_)가 4개씩 추가한다.
 * 2-1-1. 언더바(_)는 재귀함수의 파라미터에 추가해 한 번 반복할 때마다 "____"를 추가해서 전달한다.
 * 2-2. depth가 입력으로 들어온 N이 될 때까지 반복한다.
 * 3. 마지막 종료시 출력되는 문자열이 약간 다르다. 즉, 기저 조건에서 출력되는 문자열이 다르다.
 */
public class Main {
    static String s1 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    static String s2 = "\"재귀함수가 뭔가요?\"";
    static String s3 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String s4 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String s5 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String s6 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String s7 = "라고 답변하였지.";
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 1. 처음 1번만 출력되는 문자열이 무엇인지 파악한다.
        sb.append(s1).append('\n');
        recursive(0, "");
        System.out.print(sb);
    }

    static void recursive(int depth, String under) {
    	// 2-2. depth가 입력으로 들어온 N이 될 때까지 반복한다.
        if(depth == n) {
        	// 3. 마지막 종료시 출력되는 문자열이 약간 다르다. 즉, 기저 조건에서 출력되는 문자열이 다르다.
            sb.append(under).append(s2).append('\n');
            sb.append(under).append(s6).append('\n');
            sb.append(under).append(s7).append('\n');
            return;
        }
        // 2. 재귀함수로 반복되는 부분이 무엇인지 파악한다.
        sb.append(under).append(s2).append('\n');
        sb.append(under).append(s3).append('\n');
        sb.append(under).append(s4).append('\n');
        sb.append(under).append(s5).append('\n');
        // 2-1. 한 번 반복할 때마다 문자열 앞에 언더바(_)가 4개씩 추가한다.
        // 2-1-1. 언더바(_)는 재귀함수의 파라미터에 추가해 한 번 반복할 때마다 "____"를 추가해서 전달한다.
        recursive(depth+1, under + "____");
        sb.append(under).append(s7).append('\n');
    }
}

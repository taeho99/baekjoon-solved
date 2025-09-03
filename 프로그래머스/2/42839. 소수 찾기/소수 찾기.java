import java.util.*;
class Solution {
    int elementCnt, selectCnt;
    char[] elementList, selectList;
    boolean[] visited;
    StringBuilder sb;
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        elementList = numbers.toCharArray();
        elementCnt = elementList.length;
        for(selectCnt=1; selectCnt<=elementCnt; selectCnt++) {
            visited = new boolean[elementCnt];
            selectList = new char[selectCnt];
            permutation(0);
        }
        for(int num : set) {
            System.out.println(num);
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    void permutation(int depth) {
        if(depth == selectCnt) {
            sb = new StringBuilder();
            for(char c : selectList) {
                sb.append(c);
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        for(int elementIdx=0; elementIdx<elementCnt; elementIdx++) {
            if(visited[elementIdx]) continue;
            visited[elementIdx] = true;
            selectList[depth] = elementList[elementIdx];
            permutation(depth+1);
            visited[elementIdx] = false;
        }
    }
    
    boolean isPrime(int n) {
        if(n == 0 || n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
	    return true;
    }
}
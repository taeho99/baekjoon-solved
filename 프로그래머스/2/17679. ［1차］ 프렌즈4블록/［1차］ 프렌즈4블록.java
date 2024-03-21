import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] block = new char[m][n];
        for(int i=0; i<m; i++) {
            block[i] = board[i].toCharArray();
        }

        int answer = 0;
        while(true) {
            HashSet<String> willRemove = new HashSet<>();

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c1 = block[i][j];
                    if(c1 == 0) continue;
                    char c2 = block[i][j + 1];
                    char c3 = block[i + 1][j];
                    char c4 = block[i + 1][j + 1];

                    if (c1 == c2 && c2 == c3 && c3 == c4) {
                        willRemove.add(i + " " + j);
                        willRemove.add(i + " " + (j + 1));
                        willRemove.add((i + 1) + " " + j);
                        willRemove.add((i + 1) + " " + (j + 1));
                    }
                }
            }

            if(willRemove.isEmpty()) break;
            answer += willRemove.size();

            char[][] newBlock = new char[m][n];
            for (int x = 0; x < n; x++) {
                for (int y = m - 1; y >= 0; y--) {
                    if (!willRemove.contains(y + " " + x)) {
                        newBlock[y][x] = block[y][x];
                    } else {
                        newBlock[y][x] = ' ';
                    }
                }
            }
            block = new char[m][n];
            for (int x = 0; x < n; x++) {
                Queue<Character> queue = new LinkedList<>();
                for (int y = m - 1; y >= 0; y--) {
                    if (newBlock[y][x] != ' ')
                        queue.add(newBlock[y][x]);
                }
                for (int y = m - 1; !queue.isEmpty(); y--) {
                    block[y][x] = queue.poll();
                }
            }
        }

        return answer;
    }
}
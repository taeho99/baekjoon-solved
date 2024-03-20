import java.util.*;

class Solution {

    private class Info {
        int node, sheep, wolf;
        HashSet<Integer> visited;

        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }

    private static ArrayList<Integer>[] tree; //adj

    public int solution(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for(int i=0; i<tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

        int answer = 0;

        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));

        while(!queue.isEmpty()) {
            Info now = queue.poll();
            answer = Math.max(answer, now.sheep);

            now.visited.addAll(tree[now.node]);

            for (int next : now.visited) {
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);

                if(info[next] == 1) {
                    if(now.sheep != now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                } else {
                    queue.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }
        return answer;
    }
}
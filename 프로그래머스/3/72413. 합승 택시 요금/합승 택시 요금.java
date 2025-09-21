import java.util.*;
class Solution {
    int vertexSize, edgeSize;
    ArrayList<Node>[] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        vertexSize = n;
        edgeSize = fares.length;
        graph = new ArrayList[n];
        
        for(int idx=0; idx<n; idx++) {
            graph[idx] = new ArrayList<>();
        }
        
        for(int[] fare : fares) {
            int u = fare[0]-1;
            int v = fare[1]-1;
            int w = fare[2];
            
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }
        
        int[] best = dijkstra(s-1);
        
        int minCost = Integer.MAX_VALUE;
        for(int adj=0; adj<n; adj++) {
            int[] alone = dijkstra(adj);
            
            int cost = best[adj] + alone[a-1] + alone[b-1];
            minCost = Math.min(minCost, cost);
        }
        
        return minCost;
    }
    
    int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        int[] best = new int[vertexSize];
        Arrays.fill(best, Integer.MAX_VALUE);
        
        best[start] = 0;
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if(curNode.weight > best[curNode.end]) continue;

            for (Node adjNode : graph[curNode.end]) {
                if(best[adjNode.end] > curNode.weight + adjNode.weight) {
                    best[adjNode.end] = curNode.weight + adjNode.weight;
                    pq.add(new Node(adjNode.end, best[adjNode.end]));
                }
            }
        }
        return best;
    }
    
    class Node {
        int end, weight;
        
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
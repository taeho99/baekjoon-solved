import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  SWEA.1251 하나로_프림
 *
 *  1. 섬의 개수와 각 섬의 좌표, 세율을 입력받는다.
 *      1-1. 각 섬의 좌표는 정점 배열에 저장한다.
 *  2. 정점 배열로 가중치가 있는 무향 그래프 인접 행렬을 만든다.
 *      2-1. 두 정점 사이의 거리를 구하고 환경 부담금을 구해 간선의 비용을 구한다.
 *  3. 프림 알고리즘을 위해 minEdge[] 배열을 MAX_VALUE로 초기화한다.
 *  4. 0번 정점을 트리의 시작 정점으로 지정한다.
 *  5. 방문하지 않은 정점 중 간선의 비용이 최소인 정점을 구한다.
 *  6. 그 정점을 선택하여 트리에 넣고 비용의 합에 더한다.
 *  7. 선택된 정점과 다른 정점들을 비교해서 minEdge[] 값을 갱신한다.
 *  8. 최소 비용을 반올림하여 출력한다.
 */
public class Solution {
    static int vertexCnt;
    static boolean[] visited;
    static double taxRate;
    static double[] minEdge;
    static double[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1, st2;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 섬의 개수와 각 섬의 좌표, 세율을 입력받는다.
            vertexCnt = Integer.parseInt(br.readLine()); // 0, 1, ... , (vertexCnt-1)
            int[] verticesX = new int[vertexCnt];
            int[] verticesY = new int[vertexCnt];
            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < vertexCnt; idx++) {
                // 1-1. 각 섬의 좌표는 정점 배열에 저장한다.
                verticesX[idx] = Integer.parseInt(st1.nextToken());
                verticesY[idx] = Integer.parseInt(st2.nextToken());
            }
            taxRate = Double.parseDouble(br.readLine());

            // 2. 정점 배열로 가중치가 있는 무향 그래프 인접 행렬을 만든다.
            adjMatrix = new double[vertexCnt][vertexCnt];
            for (int start = 0; start < vertexCnt; start++) {
                for (int end = start + 1; end < vertexCnt; end++) {
                    // 2-1. 두 정점 사이의 거리를 구하고 환경 부담금을 구해 간선의 비용을 구한다.
                    double distSquare = Math.pow(verticesX[start] - verticesX[end], 2) + Math.pow(verticesY[start] - verticesY[end], 2);
                    adjMatrix[start][end] = adjMatrix[end][start] = taxRate * distSquare;
                }
            }

            // 3. 프림 알고리즘을 위해 minEdge[] 배열을 MAX_VALUE로 초기화한다.
            minEdge = new double[vertexCnt];
            visited = new boolean[vertexCnt];
            Arrays.fill(minEdge, Double.MAX_VALUE);

            // 4. 0번 정점을 트리의 시작 정점으로 지정한다.
            minEdge[0] = 0.0;
            double minimumCost = 0;
            for (int idx = 0; idx < vertexCnt; idx++) {
                double min = Double.MAX_VALUE;
                int minVertex = -1;

                // 5. 방문하지 않은 정점 중 간선의 비용이 최소인 정점을 구한다.
                for (int vertex = 0; vertex < vertexCnt; vertex++) {
                    if (visited[vertex]) continue;
                    if (minEdge[vertex] < min) {
                        minVertex = vertex;
                        min = minEdge[minVertex];
                    }
                }

                // 6. 그 정점을 선택하여 트리에 넣고 비용의 합에 더한다.
                visited[minVertex] = true;
                minimumCost += min;

                // 7. 선택된 정점과 다른 정점들을 비교해서 minEdge[] 값을 갱신한다.
                for (int vertex = 0; vertex < vertexCnt; vertex++) {
                    if (!visited[vertex] && adjMatrix[minVertex][vertex] < minEdge[vertex]) {
                        minEdge[vertex] = adjMatrix[minVertex][vertex];
                    }
                }
            }

            // 8. 최소 비용을 반올림하여 출력한다.
            sb.append(Math.round(minimumCost)).append('\n');
        }
        System.out.print(sb);
    }
}
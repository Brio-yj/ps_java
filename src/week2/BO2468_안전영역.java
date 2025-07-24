package week2;

import java.util.*;
import java.io.*;

public class BO2468_안전영역 {
    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static int[][] rain;
    static int[][] visited;

    public static void dfs(int x, int y) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (visited[nx][ny] == 0 && rain[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        int max = res;
        for (int temp = 0; temp <= 100; temp++) {
            res=0;
            rain = new int[n][n];
            visited = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rain[i][j]=board[i][j];
                    if (rain[i][j] <= temp) rain[i][j] = 0;
                    else rain[i][j] = 1;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (rain[i][j] == 1 && visited[i][j] == 0) {
                        res++;
                        dfs(i, j);
                    }
                }
            }
            if (max <= res) max = res;
        }
        System.out.println(max);
    }
}

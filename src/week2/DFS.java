package week2;

public class DFS {

    static int[][] board;
    static int[][] visited;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i];
            int ny = dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (visited[nx][ny] == 0) dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        n = 4;
        m = 4;
        board = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[n][m] == 1 && visited[n][m] == 0) dfs(n, m);
            }
        }
    }
}

package week2;

import java.util.*;
import java.io.*;

public class BO2636_치즈 {
    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static int[][] board, visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Point> pList;
    static List<Integer> cntList = new ArrayList();

    static void bfs(int r, int c) {
        pList = new ArrayList();
        Queue<Point> q = new LinkedList();
        q.add(new Point(r, c));
        visit[r][c] = 1;
        int cnt = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int cr = cur.r;
            int cc = cur.c;
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (board[nr][nc] == 0 && visit[nr][nc] == 0) {
                        visit[nr][nc] = 1;
                        q.add(new Point(nr, nc));
                    }
                    else if (board[nr][nc] == 1 && visit[nr][nc] == 0) {
                        cnt++;
                        visit[nr][nc] = 1;
                        pList.add(new Point(nr, nc));
                    }
                }
            }
        }
        for (Point p : pList) {
            //System.out.println("r= "+p.r+" c= "+p.c);
            board[p.r][p.c] = 0;
        }
        /*
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                System.out.print(board[a][b] + " ");
            }
            System.out.println();
        }
        System.out.println("~~~~~~~~~~~~~~~~");
         */
        cntList.add(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            boolean cheese = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1) {
                        visit = new int[N][M];
                        cheese = true;
                        bfs(0, 0);
                    }
                }
            }
            if (!cheese) break;
        }
        System.out.println(cntList.size());
        System.out.println(cntList.get(cntList.size() - 1));
    }
}

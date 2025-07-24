package week2;

import java.io.*;
import java.util.*;

/*
가로 =m=col
세로 =n=row
입력 형태 (m,n)

벡터에선 기본적으로 (row,col) 형태로 움직인다
 */
public class BO1012_유기농배추 {
    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static int[][] visited;
    //전역 관리
    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList();
        q.add(new Point(x, y));

        visited[x][y] = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny] == 0 && board[nx][ny] == 1) {
                        visited[nx][ny] = 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
        public static void main (String[]args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                answer = 0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                m = Integer.parseInt(st.nextToken());
                n = Integer.parseInt(st.nextToken());
                board = new int[n][m];
                visited = new int[n][m];
                //보드 테두리
                int cabbage_cnt = Integer.parseInt(st.nextToken());
                for (int cabbage = 0; cabbage < cabbage_cnt; cabbage++) {
                    st = new StringTokenizer(br.readLine());
                    int mm = Integer.parseInt(st.nextToken());
                    int nn = Integer.parseInt(st.nextToken());
                    board[nn][mm] = 1;
                }

                for (int board_r = 0; board_r < n; board_r++) {
                    for (int board_c = 0; board_c < m; board_c++) {
                        if (visited[board_r][board_c] == 0 && board[board_r][board_c] == 1) {
                            answer++;
                            bfs(board_r, board_c);
                        }
                    }
                }
                System.out.println(answer);
            }
        }
    }

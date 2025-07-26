package week2;
import java.util.*;
import java.io.*;
public class BO14502_연구소_GEM {
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    static int N, M;
    static int[][] board;
    static int maxCnt=0;
    static List<Point> emptyCell = new ArrayList();
    static List<Point> virusCell = new ArrayList();
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};

    public static void makeWall(int start, int depth){
        if(depth==3){
            bfs();
        }
        for(int i=start;i<emptyCell.size();i++){
            Point temp = emptyCell.get(i);
            board[temp.r][temp.c]=1;
            makeWall(i+1,depth+1);
            board[temp.r][temp.c]=0;
        }
    }
    public static void bfs(){
        Queue<Point> q = new LinkedList();
        for(Point virus : virusCell){
            q.add(virus);
        }
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>0&&nc>0) board[nr][nc]=2;
                q.add(new Point(nr,nc));
            }
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==0) emptyCell.add(new Point(i,j));
                if(board[i][j]==2) virusCell.add(new Point(i,j));
            }
        }
        makeWall(0,0);
    }
}

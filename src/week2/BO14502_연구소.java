package week2;
import java.util.*;
import java.io.*;
public class BO14502_연구소 {
    static class Point{
        int r, c;
        Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    static int N,M;
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static int[][] board;
    static int[][] visit;
    static int[][] t_board;
    static int[][] t_visit;
    public static void dfs(int r,int c){
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<N && nc>=0 && nc<M){
                if(t_board[nr][nc]==0 && t_visit[nr][nc]==0){
                    t_board[nr][nc]=2;
                    t_visit[nr][nc]=1;
                    dfs(nr,nc);
                }
            }
        }
    }
    public static void arrCopy(){
        t_board=new int[N][M];
        t_visit=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                t_board[i][j]=board[i][j];
                t_visit[i][j]=visit[i][j];
            }
        }
    }
    public static int cntSafe(){
        int cnt=0;
        for(int r=0;r<N;r++){
            for(int c=0;c<M;c++){
                if(t_board[r][c]==0) cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visit = new int[N][M];

        // 보드 초기화
        Point[] pv = new Point[N*M];
        int idx=0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==0){
                    pv[idx]=new Point(i,j);
                    idx++;
                }
            }
        }
        //보드 완성, 차단벽 후보 좌표 완성

        int size = N*M;
        List<Integer> nList = new ArrayList();
        for(int i=0;i<idx-2;i++){
            for(int j=i+1;j<idx-1;j++){
                for(int k=j+1;k<idx;k++){
                    arrCopy();
                    t_board[pv[i].r][pv[i].c]=1;
                    t_board[pv[j].r][pv[j].c]=1;
                    t_board[pv[k].r][pv[k].c]=1;
                    int res =0;
                    for(int r=0;r<N;r++){
                        for(int c=0;c<M;c++){
                            if(t_board[r][c]==2 && t_visit[r][c]==0) {
                                t_visit[r][c]=1;
                                dfs(r,c);
                            }
                        }
                    }
                    nList.add(cntSafe());
                }
            }
        }
        nList.sort((n1,n2)->{
            return n2.compareTo(n1);
        });
        System.out.println(nList.get(0));
    }

}

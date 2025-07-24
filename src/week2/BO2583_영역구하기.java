package week2;

import java.util.*;
import java.io.*;

import static java.lang.StrictMath.min;

public class BO2583_영역구하기 {
    public static class Point{
        int x; int y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int m;
    static int n;
    static int[] dx ={1,-1,0,0};
    static int[] dy ={0,0,-1,1};
    static int[][] board;
    static int[][] visited;
    static List<Integer> nList = new ArrayList();

    public static void bfs(int x,int y){
        int board_size=1;
        Queue<Point> q = new LinkedList();
        q.add(new Point(x,y));
        visited[x][y]=1;
        // 첫 시작, 크기 초기화, 큐에 삽입, 방문처리
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n){
                    if(visited[nx][ny]==0 && board[nx][ny]==0){
                        board_size++;
                        q.add(new Point(nx,ny));
                        visited[nx][ny]=1;
                    }
                }
            }
            if(q.isEmpty())nList.add(board_size);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        visited = new int[m][n];
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int before_x1 = Integer.parseInt(st.nextToken());
            int before_y1 = Integer.parseInt(st.nextToken());
            int before_x2 = Integer.parseInt(st.nextToken());
            int before_y2 = Integer.parseInt(st.nextToken());
            //여기서부터 반대로 넣어주기
            for(int x=before_y1;x<before_y2;x++){
                for(int y=before_x1;y<before_x2;y++){
                    board[x][y]=1;
                }
            }
        }
        /*
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        */
        //보드 완성
        int answer=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0 && visited[i][j]==0) {
                    answer++;
                    bfs(i,j);
        /*
                    for(int a=0;a<m;a++){
                        for(int b=0;b<n;b++){
                            System.out.print(visited[a][b]+" ");
                        }
                        System.out.println();
                    }
                    System.out.println("-------------------");
        */
                }
            }
        }
        System.out.println(answer);
        Collections.sort(nList);
        for(Integer num:nList) System.out.print(num+" ");
    }
}

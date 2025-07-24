package week2;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static int n,m;
    static int[][] board;
    static int[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void bfs(int x,int y){
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x,y});
        visited[x][y]=1;
        while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[0]+dy[i];
            }
        }
    }
    public static void main(String[] args){
        n=4;
        m=4;
        board = new int[n][m];
        visited = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && board[i][j]==1) bfs(i,j);
            }
        }
    }
}
/*
    poll = peek(),pop() 동시에 진행
    .add(new int[]{x,y}; -->2개짜리 배열 큐에 삽입

* */

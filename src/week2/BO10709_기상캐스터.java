package week2;
import java.io.*;
import java.util.*;

public class BO10709_기상캐스터 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] board = new int[H][W];
        for(int i=0;i<H;i++){
            String s = br.readLine();
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='c') board[i][j]=-2;
            }
        }
        for(int i=0;i<H;i++){
            boolean existC = false;
            int cnt =1;
            for(int j=0;j<W;j++){
                if(!existC && board[i][j]==0){board[i][j]=-1;}
                //아직 구름 없을때
                else if(!existC && board[i][j]==-2){
                    existC=true;
                    board[i][j]=0;
                }
                //처음 구름 발견
                else if(existC && board[i][j]==0){
                    board[i][j]=cnt;
                    cnt++;
                }
                //구름 있는거 확인하고 빈칸 봤을때
                else if(existC && board[i][j]==-2){
                    board[i][j]=0;
                    cnt=1;
                }
                //구름 있는거 확인했는데 또 구름
            }
        }
        for(int i=0;i<H;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<W;j++){
                sb.append(board[i][j]).append(" ");
            }
            System.out.println(sb.toString().trim());
            sb.setLength(0);
        }
    }
}

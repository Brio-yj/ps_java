package week2;
import java.io.*;
import java.util.*;
public class BO1992_쿼드트리 {

    static int N;
    static int[][] board;
    static String answer="";

    public static void solve(int r1, int c1, int r2, int c2){
        //public static string solve
        int first_val = board[r1][c1];
        boolean constancy = true;
        /*
        if(x1==0 && y1==4 && x2==4 && y2==8) {
            for(int i=x1;i<x2;i++){
                for(int j=y1;j<y2;j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
         */
        for(int i=r1;i<r2;i++){
            for(int j=c1;j<c2;j++){
                if(board[i][j]!=first_val){
                    constancy = false;
                    //break;
                }
            }
            //if(!constancy) break; 더 돌릴 필요가 없다
        }
        //전체 탐색

        if(constancy) answer+= first_val;
        //if(constancy) return String.valueOf(firstVal)
        else{
            //문자열을 추가 및 삭제 할때는 StringBuilder를 사용하자
            //StringBuilder sb = new StringBuilder();
            answer+="(";
            //sb.append("(")
            //sb.append(solve(~)) 이런식으로
            solve(r1,c1,(r1+r2)/2,(c1+c2)/2);
            solve(r1,(c1+c2)/2,(r1+r2)/2,c2);
            solve((r1+r2)/2,c1,r2,(c1+c2)/2);
            solve((r1+r2)/2,(c1+c2)/2,r2,c2);
            answer+=")";
            //return sb.toString();
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        //보드 초기화
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                board[i][j] = s.charAt(j)-'0';
            }
        }
        /*
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------");
        */
        //str->board

        solve(0,0,N,N);
        System.out.println(answer);
    }
}

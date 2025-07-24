package week2;
import java.io.*;
import java.util.*;
public class BO2828_사과담기게임 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine());

        int start = 0;
        int end = M-1;
        int answer=0;
        for(int i=0;i<T;i++){
            int t = Integer.parseInt(br.readLine());
            t--;
            if(start<=t && t<=end) continue;
            else{
                if(t<start){
                    int move = start-t;
                    answer +=move;
                    start-=move;
                    end-=move;
                }
                if(end<t){
                    int move = t-end;
                    answer +=move;
                    start+=move;
                    end+=move;
                }
            }
        }
        System.out.println(answer);
    }
}

package week2;
import java.io.*;
import java.util.*;
public class BO10709_기상캐스터_GEM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<H;i++){
            int timer = -1;
            String line = br.readLine();
            for(int j=0;j<line.length();j++){
                if(line.charAt(j)=='c'){
                    timer =0;
                }
                else if(timer!=-1){
                    timer++;
                }
                sb.append(timer).append(" ");
            }
            sb.append(timer).append("\n");
        }
        System.out.println(sb);
    }
}

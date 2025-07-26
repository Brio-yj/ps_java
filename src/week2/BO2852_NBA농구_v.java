package week2;
import java.util.*;
import java.io.*;
public class BO2852_NBA농구_v {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int ti1=0, ti2=0;
        int sc1=0, sc2=0;
        int cur=0, prev=0;

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int win = Integer.parseInt(st.nextToken());

            String s = st.nextToken();
            int min = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
            cur = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0') + min * 60;

            if(sc1>sc2) {
                ti1+=cur-prev;
            }
            else if(sc1<sc2){
                ti1+=cur-prev;
            }
            prev=cur;
            //시간 관리
            if(win==1) sc1++;
            if(win==2) sc2++;
        }
        if(sc1>sc2) {ti1+=48*60-cur;}
        else if(sc1<sc2){ti2+=48*60-cur;}

        int min1=ti1/60;
        int sec1=ti1%60;
        int min2=ti2/60;
        int sec2=ti2%60;

        System.out.printf("%02d"+":"+"%02d\n",min1,sec1);
        System.out.printf("%02d"+":"+"%02d",min2,sec2);
    }
}

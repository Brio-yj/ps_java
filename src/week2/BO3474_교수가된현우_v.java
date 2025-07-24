package week2;

import java.io.*;

public class BO3474_교수가된현우_v {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int cnt =0;
            for(int n=5;num>n;n*=5){
                cnt+=num/n;
            }
            System.out.println(cnt);
        }
    }
}

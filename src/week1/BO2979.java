package week1;

import java.io.*;
import java.util.*;

public class BO2979 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[101];
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(;a<b;a++)arr[a]++;
        }
        int sum=0;
        for(int num : arr){
            if(num==1) sum+=num*A;
            if(num==2) sum+=num*B;
            if(num==3) sum+=num*C;
        }
        System.out.print(sum);
    }
}
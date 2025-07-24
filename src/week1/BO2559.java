package week1;

import java.util.*;
import java.io.*;

import static java.lang.Math.max;

public class BO2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer num = new StringTokenizer(br.readLine());
        int maxSum = -10000002;
        int[] psum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            psum[i] = psum[i - 1] + Integer.parseInt(num.nextToken());
        }
        for (int i = m; i <= n; i++) {
            maxSum = max(maxSum, psum[i] - psum[i - m]);
        }
        System.out.print(maxSum);




        /*
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(num.nextToken());
            sum+=arr[i];
            if(i == m-1)maxSum =sum;
            if(i>=m){
                sum-=arr[i-m];
                maxSum = (maxSum>sum)? maxSum : sum;
            }
        }
        System.out.print(maxSum);
         */
    }
}

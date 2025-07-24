package week1;

import java.io.*;
import java.util.*;

public class BO1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (nums[i] + nums[j] < m) {
                i++;
            }
            else if (nums[i] + nums[j] > m) {
                j--;
            }
            else {
                cnt++;
                i++;
                j--;
            }
        }
        System.out.println(cnt);
    }
}

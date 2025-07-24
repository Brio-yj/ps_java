package week1;

import java.io.*;
import java.util.*;

public class BO1629_곱셈_v {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        if(b%2==0)System.out.println(solve(a, b, c));
        else System.out.println((solve(a, b-1, c)*a)%c);
    }

    public static long solve(int a, int b, int c) {
        if (b == 1) {return a % c;}
        long remain = solve(a, b / 2, c);
        long result = (remain * remain)%c;
        return result;
    }
}
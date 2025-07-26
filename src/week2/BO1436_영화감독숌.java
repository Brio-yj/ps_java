package week2;
import java.util.*;
import java.io.*;
public class BO1436_영화감독숌 {
    public static boolean solve(int num){
        String s = String.valueOf(num);
        return s.contains("666");
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int idx=0;
        int num=0;
        while(idx!=N){
            num++;
            if(solve(num)) idx++;
        }
        System.out.println(num);
    }
}

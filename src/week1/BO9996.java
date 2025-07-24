package week1;
import java.util.*;
import java.io.*;
public class BO9996 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");
        for(int i=0;i<n;i++){
            String target = br.readLine();
            solve(pattern,target);
        }
    }
    public static void solve(String[] pattern,String target) {
        if(pattern[0].length()+pattern[1].length()>target.length()){
            System.out.println("NE");
            return;
        }
        for(int i=0;i<pattern[0].length();i++){
            if(pattern[0].charAt(i)!=target.charAt(i)){
                System.out.println("NE");
                return;
            }
        }
        StringBuilder sb1 = new StringBuilder(pattern[1]).reverse();
        StringBuilder sb2 = new StringBuilder(target).reverse();
        for(int i=0;i<sb1.length();i++){
            if(sb1.charAt(i)!=sb2.charAt(i)){
                System.out.println("NE");
                return;
            }
        }
        System.out.println("DA");
    }
}

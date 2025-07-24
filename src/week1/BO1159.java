package week1;
import java.util.*;
import java.io.*;
public class BO1159 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[26];
        for(int i=0;i<n;i++){
            String s =br.readLine();
            arr[s.charAt(0)-'a']++;
        }
        boolean found = false;
        for(int i=0;i<26;i++){
            if(arr[i]>=5){
                System.out.print((char)('a'+i));
                found = true;
            }
        }
        if(!found) System.out.print("PREDAJA");
    }
}

package week1;

import java.io.*;
import java.util.*;
public class BO10808 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++)arr[s.charAt(i)-'a']++;
        for(int num : arr) System.out.print(num+" ");
    }
}

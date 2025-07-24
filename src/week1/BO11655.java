package week1;
import java.util.*;
import java.io.*;
public class BO11655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)==' ') continue;
            if('A'<=sb.charAt(i)&&sb.charAt(i)<'N'){
                sb.setCharAt(i,(char)(sb.charAt(i)+13));
            }
            else if('N'<=sb.charAt(i)&&sb.charAt(i)<='Z'){
                sb.setCharAt(i,(char)('A'+(sb.charAt(i)-'N')));
            }
            else if('a'<=sb.charAt(i)&&sb.charAt(i)<'n'){
                sb.setCharAt(i,(char)(sb.charAt(i)+13));
            }
            else if('n'<=sb.charAt(i)&&sb.charAt(i)<='z'){
                sb.setCharAt(i,(char)('a'+(sb.charAt(i)-'n')));
            }
        }
        System.out.print(sb);
    }
}


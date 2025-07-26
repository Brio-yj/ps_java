package week2;
import java.util.*;
import java.io.*;
public class BO9012_괄호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String s = br.readLine();
            Stack<Character> st = new Stack();
            for(int j=0;j<s.length();j++){
                if(!st.isEmpty() && s.charAt(j)==')' && st.peek()=='(') st.pop();
                else st.push(s.charAt(j));
            }
            if(st.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

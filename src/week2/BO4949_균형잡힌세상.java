package week2;

import java.util.*;
import java.io.*;

public class BO4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;
            Stack<Character> st = new Stack();
            for (int i = 0; i < s.length(); i++) {
                if (!st.isEmpty() && s.charAt(i) == ')' && st.peek() == '(') st.pop();
                else if (!st.isEmpty() && s.charAt(i) == ']' && st.peek() == '[') st.pop();
                else if(s.charAt(i) == ']'||s.charAt(i) == '['||
                        s.charAt(i) == ')'|| s.charAt(i) == '(')
                    st.push(s.charAt(i));
            }
            if (st.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}

package week1;

import java.io.*;
import java.util.*;

public class BO3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> st = new Stack();
            for (char c : str.toCharArray()) {
                if (!st.isEmpty()&&c == st.peek()) st.pop();
                else{st.push(c);}
            }
            if (st.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}

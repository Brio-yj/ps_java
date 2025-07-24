package week2;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class BO2870_수학숙제_v {
    static List<BigInteger> nList = new ArrayList();

    public static boolean checkNum(char c) {
        return 0 <= c - '0' && c - '0' <= 9;
        // return '0'<=c && c<='9';
    }
    public static void strInt(String s) {
        BigInteger num = new BigInteger(s);
        nList.add(num);
    }
    public static void solve(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (checkNum(s.charAt(i))) sb.append(s.charAt(i));
            else {
                if (sb.length()>0){
                    strInt(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if (sb.length()>0) strInt(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            solve(s);
        }
        nList.sort(null);
        for (BigInteger num : nList) {
            System.out.println(num);
        }
    }
}

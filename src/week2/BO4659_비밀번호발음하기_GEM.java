package week2;

import java.io.*;
import java.util.*;

public class BO4659_비밀번호발음하기_GEM {
    static boolean checkVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    static boolean solve(String s) {
        boolean hasVowel = false;
        int vowelCnt = 0;
        int consonantCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (checkVowel(s.charAt(i))) {
                hasVowel = true;
                vowelCnt++;
                consonantCnt = 0;
            }
            else {
                consonantCnt++;
                vowelCnt = 0;
            }
            if (vowelCnt >= 3 || consonantCnt >= 3) return false;
            char now = s.charAt(i);
            if (i >= 1) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    if (s.charAt(i) == 'e' || s.charAt(i) == 'o') continue;
                    else return false;
                }
            }
        }
        return hasVowel;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;
            if (solve(s)) sb.append("<").append(s).append("> is acceptable.");
            else sb.append("<").append(s).append("> is not acceptable.");
            System.out.println(sb.toString());
        }
    }
}

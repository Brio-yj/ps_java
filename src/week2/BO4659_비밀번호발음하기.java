package week2;

import java.util.*;
import java.io.*;

public class BO4659_비밀번호발음하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine().toString();
            if (s.equals("end")) break;

            boolean accept = true;
            boolean only자음 = true;
            for (int i = 0; i < s.length(); i++) {
                if ("aeiou".indexOf(s.charAt(i)) != -1) {
                    only자음 = false;
                }
            }
            if (only자음) {
                System.out.println("<" + s + ">" + " is not acceptable.");
                accept = false;
            }
            //모음 유무확인
            if (accept == true) {
                for (int i = 0; i < s.length() - 1; i++) {
                    if (s.charAt(i) == s.charAt(i + 1)) {
                        if (s.charAt(i) == 'e' && s.charAt(i + 1) == 'e') continue;
                        else if (s.charAt(i + 1) == 'o' && s.charAt(i + 1) == 'o') continue;
                        else {
                            System.out.println("<" + s + ">" + " is not acceptable.");
                            accept = false;
                            break;
                        }
                    }
                }
            }
            //연속 확인
            if (accept == true) {
                int 자음cnt = 0;
                int 모음cnt = 0;
                for (int i = 0; i < s.length(); i++) {
                    if ("aeiou".indexOf(s.charAt(i)) != -1) {
                        모음cnt++;
                        자음cnt = 0;
                    }
                    else {
                        모음cnt = 0;
                        자음cnt++;
                    }
                    if (모음cnt == 3 || 자음cnt == 3) {
                        System.out.println("<" + s + ">" + " is not acceptable.");
                        accept = false;
                        break;
                    }
                }
            }
            if (accept) System.out.println("<" + s + ">" + " is acceptable.");
        }
    }
}

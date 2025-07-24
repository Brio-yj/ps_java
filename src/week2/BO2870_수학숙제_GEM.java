package week2;
import java.util.*;
import java.io.*;
import java.math.*;
public class BO2870_수학숙제_GEM {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<BigInteger> nList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();

            for(int j=0;j<s.length();j++){
                if(Character.isDigit(s.charAt(j))) sb.append(s.charAt(j));
                else{
                    if(sb.length()>0) {
                        nList.add(new BigInteger(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }
        }
    }
}
/*
    1. BigInteger 사용법
    2. sb 초기화
    3. sb 비어있는지 확인
    4. Charater.isDigit()

 */

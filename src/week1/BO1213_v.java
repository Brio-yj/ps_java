package week1;

import java.io.*;

public class BO1213_v {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        //String line = sc.nextLine();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int[] arr = new int[26];
        for(char c : line.toCharArray()){ arr[c-'A']++;}
        //for (int i = 0; i < line.length(); i++) {arr[line.charAt(i) - 65]++;}
        //알파벳 갯수 확인

        // 2. [앞 절반] 만들기와 홀수 체크를 동시에!
        int cntOdd = 0;
        char mid = ' ';
        StringBuilder front = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                cntOdd++;
                mid = (char) (arr[i]-'A');
            }
            for(int j=0;j<arr[i]/2;j++){front.append((char)+(i+'A'));}
        }
        if(cntOdd>2) System.out.println("I'm Sorry Hansoo");
        else{
            StringBuilder result = new StringBuilder(front);
            if(mid !=' ') result.append(mid);
            result.append(front.reverse());
            System.out.println(result.toString());
        }
    }
/*
    public static void solve(int chkOdd, int[] arr, int size) {
        if (size % 2 == 0) {    //입력 짝수일때
            if (chkOdd >= 1) {System.out.println("I'm Sorry Hansoo");}  //입력짝수,홀수 1개이상
            else {
                String s = new String();
                char alpha = ' ';

                for (int i = 0; i < arr.length; i++) {arr[i]/=2;}   // 알파벳 갯수 절반으로 줄이기
                for (int i = 0; i < arr.length; i++) {

                    if(arr[i]!=0) {
                        for(int j=0;j<arr[i];j++){
                        alpha = (char) ('A' + i);
                        s += alpha;
                        }
                    }
                }
                //문자열 앞판 완성
                String answer = new String();
                for (int i = s.length() - 1; i >= 0; i--) {answer += s.charAt(i);}   // 문자열 뒷판 완성
                s += answer;
                System.out.println(s);
                return;
            }
        }
        else {
            if (chkOdd >= 2) {
                System.out.println("I'm Sorry Hansoo");
            }
            else {
                char mid = ' ';
                for (int i = 0; i < arr.length; i++) {if (arr[i] % 2 != 0) mid = (char) ('A' + i);}
                //가운데 끼울 문자 찾기
                for (int i = 0; i < arr.length; i++) {arr[i]/=2;}
                // 알파벳 갯수 절반으로 줄이기

                String s = new String();
                char alpha = ' ';
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i]!=0) {
                        for(int j=0;j<arr[i];j++){
                        alpha = (char) ('A' + i);
                        s += alpha;
                        }
                    }
                }
                //앞판 완성
                String answer = new String();
                for (int i = s.length() - 1; i >= 0; i--) {
                    answer += s.charAt(i);
                }
                //뒷판 완성
                s = s + mid + answer;
                System.out.println(s);
                return;
            }
        }
    }
*/
}




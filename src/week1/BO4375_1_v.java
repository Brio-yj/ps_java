package week1;

import java.io.*;
import java.util.*;

public class BO4375_1_v {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Integer> numList = new ArrayList();
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            List<Integer> List = new ArrayList();
            List.add(1 % n);
            //리스트 첫 값 삽입
            int i = 0;
            while (true) {
                if (i == 10) break;
                int cur = 0;
                cur += Math.pow(10, i);
                if (List.get(i) == 0 && cur > n) {
                    System.out.println(i + 1);
                    break;
                }
                //값 확인하고 0이면서 넘어 갔을때 자릿수 출력
                i++;
                List.add(i, ((((List.get(i - 1) * 10) % n) + 1 % n) % n));
                //리스트 값 삽입
            }

        }
    }
}

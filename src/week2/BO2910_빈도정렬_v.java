package week2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BO2910_빈도정렬_v {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer,Integer> freqMap = new HashMap();
        Map<Integer,Integer> idxMap = new HashMap();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
            idxMap.putIfAbsent(num,i);
        }
        List<Integer> nList = new ArrayList(freqMap.keySet());
        nList.sort((num1,num2)->{
            int freqCompare = freqMap.get(num1).compareTo(freqMap.get(num2));
            if(freqCompare==0) return idxMap.get(num1).compareTo(idxMap.get(num2));
            return freqMap.get(num2).compareTo(freqMap.get(num1));
        });

        StringBuilder sb = new StringBuilder();
        for(int num : nList){
            for(int i=0;i<freqMap.get(num);i++){
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
/*
    compare -> 기본적으로 오름 차순 정렬이다
    내가 내림차순으로 하고싶으면 비교 대상을 변경해야 한다
    ex) a.compare(b) =>
    a가 b보다 크면 양수를 리턴한다, 즉 a를 뒤로 보내고 b를 앞으로 보내는 오름차순 정렬이다

    b.compare(a) =>
    b가 a보다 크면 양수를 리턴한다, 즉 b를 뒤로 보내고 a를 앞으로 보내는 내림차순  정렬이다

    ==> 원래는 a를 기준으로 b를 비교 -> b를 기준으로 a를 비교 하면서 compare로직을 역으로 동작하게 변경한다

 */

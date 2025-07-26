package week2;

import java.util.*;
import java.io.*;
public class BO1068_트리_v {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<List<Integer>> nList = new ArrayList();
        for(int i=0;i<N;i++){
            nList.add(new ArrayList());
        }
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == -1) continue;
            else nList.get(num).add(i);
        }
        /*
        for(List list : nList){
            System.out.println(list);
        }
         */
        int del = Integer.parseInt(br.readLine()); // 첫삭제
        Queue<Integer> delList = new LinkedList();
        delList.add(del);
        while (!delList.isEmpty()) {
            int temp = delList.poll();
            if(nList.get(temp).size()==0) nList.get(temp).add(-1);
            else{for (int j = 0; j < nList.get(temp).size(); j++) {
                delList.add(nList.get(temp).get(j));
            }}
        }
        int res =0;
        for (int i = 0; i < N; i++) {
            if(nList.get(i).size()==0) res++;
        }
        if(res==0) res++;
        System.out.println(res);
    }
}

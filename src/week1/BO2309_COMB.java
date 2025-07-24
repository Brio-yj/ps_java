package week1;

import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;
import static java.util.Arrays.stream;

public class BO2309_COMB {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int[] res = new int[7];
        for(int i=0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

    }
    static void comb(int start, int r,int[] arr, int[] res){
        if(r==7){
            if(stream(res).sum()==100){
                sort(res);
                for(int num : res) System.out.println(num);
                System.exit(0);
            }
            return ;
        }
        for(int i=start;i<arr.length;i++){
            res[r]=arr[i];
            comb(start+1,r+1,arr,res);
        }
    }
}

/*
    r i
    0 0
    1 1
    2 2 -> if확인
    1 2
    2 3 -> if확인
    1 3
    2 4 -> if확인


 */



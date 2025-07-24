package week0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        while(true){
            String line = sc.nextLine().trim();
            if(line.isEmpty()) break;

            nums.add(Integer.parseInt(line));
        }
        int r = sc.nextInt();
        solve(nums,0,r,new ArrayList(),answer);
        for(List<Integer> res : answer)System.out.println(res);
    }
    public static void solve(List<Integer>nums,int start,int r,List<Integer>temp,List<List<Integer>> answer){
        if(r==0){
            answer.add(new ArrayList(temp));
            return;
        }

        for(int i=0;i<nums.size();i++){
            temp.add(nums.get(i));
            solve(nums,start,r-1,temp,answer);
            temp.remove(nums.get(i));
        }
    }
}

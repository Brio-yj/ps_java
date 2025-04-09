package week0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n];
        boolean[] visited = new boolean[n];
        List<Integer> current = new ArrayList<>();

        for(int i=0;i<n;i++)nums[i]=i;
        makePerm(nums,visited,current);
    }
    static void makePerm(int[] nums, boolean[] visited,List<Integer> current){
        if(current.size()==nums.length){
            System.out.println(current);
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                current.add(nums[i]);
            }

            makePerm(nums,visited,current);

            visited[i]=false;
            current.remove(current.size() - 1);
        }
    }
}

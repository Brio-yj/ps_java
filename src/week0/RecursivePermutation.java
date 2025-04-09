package week0;
import java.util.*;

public class RecursivePermutation {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 입력");

        int n = scanner.nextInt();

        int[] nums = new int[n];
        boolean[] visited = new boolean[n];
        List<Integer> current = new ArrayList<>();

        for(int i=0;i<n;i++) nums[i]=i;
        makePermutation(nums,visited,current);
    }
    static void makePermutation(int[] nums, boolean[] visited, List<Integer> current){
        if(current.size()==nums.length) {
            System.out.println(current);
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                current.add(nums[i]);

                makePermutation(nums,visited,current);

                current.remove(current.size()-1);
                visited[i]=false;
            }
        }

    }
}

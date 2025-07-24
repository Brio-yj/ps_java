package week1;

import java.util.*;

import static java.util.Arrays.sort;
import static java.util.Arrays.stream;

public class BO2309 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            inputList.add(sc.nextInt());
        }
        int[] nums = inputList.stream().mapToInt(i -> i).toArray();
        int sum = stream(nums).sum();
        int target = sum - 100;
        solve(target, nums);
    }

    public static void solve(int target, int[] nums) {
        int n1=0,n2=0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j =i+1; j < nums.length ; j++) {
                if ((nums[i] + nums[j]) == target) {
                    n1 =nums[i];n2 =nums[j];
                    break;
                }
            }
        }
        sort(nums);
        for(int t = 0;t<nums.length;t++){
            if (nums[t] == n1 || nums[t] == n2) continue;
            System.out.println(nums[t]);
        }
    }
}


/*
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[9];
    }
 */































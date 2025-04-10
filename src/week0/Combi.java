package week0;
import java.util.*;
public class Combi {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("수 배열 입력");

        List<Integer> inputList = new ArrayList<>();
        while(true){
            String line = sc.nextLine().trim();
            if(line.isEmpty()) break;

            inputList.add(Integer.parseInt(line));
        }
        int[] nums = inputList.stream().mapToInt(i->i).toArray();
        System.out.println("r");
        int r = sc.nextInt();

        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        comb(0,r,nums,new ArrayList<>(),result);

        for(List<Integer> res : result) System.out.println(res);

    }
    public static void comb(int start, int r, int[] nums,List<Integer> temp, List<List<Integer>> result){
        if(r==0){
            result.add(temp);
            return;
        }

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i-1]==nums[i]) continue;

            temp.add(nums[i]);
            comb(i+1,r-1,nums,temp,result);
            temp.remove(temp.size()-1);
        }
    }
}

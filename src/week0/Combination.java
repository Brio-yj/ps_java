package week0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Combination{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();

        System.out.println("숫자 입력");

        while(true){
            /*
                trim()을써야 공백이 들어왔을때 isEmpty()를 실행시킬 수 있다.
                즉, nextLine()은 공백도 입력으로 인식 하는듯
             */
            String line = scanner.nextLine().trim();
            if(line.isEmpty()) break;

            inputList.add(Integer.parseInt(line));
        }
        /*
            Stream : 함수형 데이터 처리 방식
            stream() : List<Integer> -> Stream<Integer>변환, Stream<Integer>-아직 객체
            mapToInt(i -> i) : Stream -> int형으로 변환, 여기서 IntStream : 기본형 int 스트림 변환 완료
            .toArray() : IntStream을 int[]로 변환
         */
        int[] nums = inputList.stream().mapToInt(i->i).toArray();
        System.out.println("조합갯수입력");
        int r = scanner.nextInt();

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        combination(nums,r,0,new ArrayList<>(),result);

        for(List<Integer> comb : result) System.out.println(comb);
    }
    public static void combination(int[] nums, int r, int start, List<Integer> temp, List<List<Integer>> result){
        if(r==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;

            temp.add(nums[i]);
            combination(nums,r-1,i+1,temp,result);
            temp.remove(temp.size()-1);
        }
    }
}

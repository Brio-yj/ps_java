package week0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Combination{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
            Scanner 클래스 사용하면 키보드 입력 받을 수 있다
            System.in -> 표준 입력 받기 = 키보드 입력
         */
        List<Integer> inputList = new ArrayList<>();
        /*
            1. List는 인터페이스, ArrayList는 인터페이스를 구현한 클래스이다.
            2. 제네릭에는 기본형 못들어간다 = 컬렉션(List,Set,Map...)은 객체만 저장 가능하다. -> 래퍼 클래스를 대신 사용해야한다.
            3. List로 선언하면 좋은게 다른 리스트로 쉽게 교체가 가능하다.
         */

        System.out.println("숫자 입력");

        while(true){
            String line = scanner.nextLine().trim();
            /*
                trim()을써야 공백이 들어왔을때 isEmpty()를 실행시킬 수 있다.
                즉, nextLine()은 공백도 입력으로 인식 하는듯
             */
            if(line.isEmpty()) break;
            inputList.add(Integer.parseInt(line));
        }
        int[] nums = inputList.stream().mapToInt(i->i).toArray();
        /*
            Stream : 함수형 데이터 처리 방식
            stream() : List<Integer> -> Stream<Integer>변환, Stream<Integer>-아직 객체
            mapToInt(i -> i) : Stream -> int형으로 변환, 여기서 IntStream : 기본형 int 스트림 변환 완료
            .toArray() : IntStream을 int[]로 변환
            일반적으로 배열로 다루는게 더 빠르니까 변환해서 사용한다
         */
        Arrays.sort(nums);
        System.out.println("조합갯수입력");
        int r = scanner.nextInt();

        List<List<Integer>> result = new ArrayList<>();
        combination(nums,r,0,new ArrayList<>(),result);
        /*
            result는 결국 new를 통해서 생성 되는 인스턴스이다.
            heap에 ArrayList 인스턴스가 생성되고
            stack에 있는 list라는 참조형 변수가 heap에 있는 ArrayList의 인스턴스 주소를 가리킨다
         */

        for(List<Integer> comb : result) System.out.println(comb);
        /*
            컬렉션 = List,Set,Map같은 자료구조 개념
            List = 인터페이스
            ArrayList = 인터페이스를 구현한 인스턴스
            Collection (상위 인터페이스 & 객체)
                └── List (하위 인터페이스 & 객체)
                    └── ArrayList (인스턴스)
                    └── LinkedList (인스턴스)
            객체를 print 하면 toString() 메서드가 실행되서 자동으로 내부 요소를 프린트 한다
         */
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

package week0;
import java.util.*;
public class Combi {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        while(true){
            String line = sc.nextLine().trim();
            if(line.isEmpty()) break;

            inputList.add(Integer.parseInt(line));
        }
        int r = sc.nextInt();
        solve(inputList,0,r,new ArrayList(),answer);
        for(List<Integer> result : answer) System.out.println(result);
    }
    public static void solve(List<Integer> nums,int start,int r,List<Integer> temp,List<List<Integer>> answer){
        if(r==0){
            answer.add(new ArrayList(temp));
            return;
        }

        for(int i=start;i<nums.size();i++){
            if(i>start && nums.get(i).equals(nums.get(i-1))) continue;
            temp.add(nums.get(i));
            solve(nums,start+1,r-1,temp,answer);
            temp.remove(nums.get(i));
        }
    }
}
/*
1. 가장 간단하게 생각 -> 입력에 중복이 없다
조합은 순서가 없으니까 한번 뽑은 숫자보다 앞의 숫자는 생각하지말자 -> i를 start로 돌리면서 i+1

2. 간단한 예시로 디버깅 하기 -> [1,2,2]
첫 번째 1을 뽑고, 뒤에서 하나를 더 뽑는다.
1과 두 번째 원소 2를 뽑음 -> [1, 2] 결과 추가
1과 세 번째 원소 2를 뽑음 -> [1, 2] 결과 추가 🚨문제1: 똑같은 조합이 또 나왔네!
첫 번째 1을 뽑는 경우는 끝났다. 이제 두 번째 원소인 2부터 시작한다.
두 번째 원소 2와 세 번째 원소 2를 뽑음 -> [2, 2] 결과 추가
두 번째 원소 2를 뽑는 경우도 끝났다. 이제 세 번째 원소인 2부터 시작한다. 🚨문제2: 이미 2로 시작하는 경우는 앞에서 했는데, 이걸 또 해야 하나?
사고 과정: "아, 배열에 똑같은 값이 있으니 컴퓨터는 이걸 다른 원소로 취급해서 중복된 결과를 만들어내는구나. 이걸 막을 방법이 필요하겠다."

3. 중복을 만들지말자
중복은 같은 숫자를 가지고 조합을 만들때 발생한다
즉 배열에서 전의 숫자와 동일하면 넘어가자

**** 4.같은걸 뽑는걸 무조건 막으면 안된다.
즉 1번은 필요하지만 그 이상은 필요없다
그러니까 반복문의 첫번째 주자가 아닐때!!를 확인하면 된다****

* */

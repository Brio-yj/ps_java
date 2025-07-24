package week0;

import java.util.*;
import java.util.stream.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> nList = new ArrayList(Arrays.asList(1, 2, 3, 3, 3));
        List<Integer> uList = nList.stream().
                distinct().
                collect(Collectors.toList());
        int[] lArrays = nList.stream().
                distinct().
                mapToInt(i -> i).
                toArray();

        int[] nums = {1, 2, 3, 3};
        int[] unums = Arrays.stream(nums).
                distinct().
                toArray();
        List<Integer> aList = Arrays.stream(nums).
                distinct().
                boxed().
                collect(Collectors.toList());
    }
}
//int -> Integer boxed로 감싸자
//Integer -> int mapToInt 한개씩 보내주자

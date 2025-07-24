package week0;
import java.util.*;
import java.util.stream.Collectors;

public class Unique {
    static public void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 3};
        int[] unums = Arrays.stream(nums).
                distinct().
                toArray();
        List<Integer> aList = Arrays.stream(nums).
                distinct().
                boxed().
                collect(Collectors.toList());

        List<Integer> nList = new ArrayList(Arrays.asList(1, 2, 2, 3, 4, 3));
        List<Integer> uList = nList.stream().
                distinct().
                collect(Collectors.toList());
        int[] Larrys = nList.stream().
                distinct().
                mapToInt(i->i).
                toArray();
    }
}

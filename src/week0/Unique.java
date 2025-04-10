package week0;
import java.util.*;
public class Unique {
    static public void main(String args[]){
        int[] nums =  {1, 2, 2, 3, 4, 3};
        Set<Integer> set = new LinkedHashSet<>();

        for(int num : nums)set.add(num);
        int[] uniqueArr =set.stream().mapToInt(i->i).toArray();
        System.out.println(set);
    }
}

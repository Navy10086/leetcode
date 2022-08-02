import java.util.*;

public class ThirdMaxNum {
    public static void main(String[] args) {
        int[] nums = {-2147483648,1,1};
        int thirdMax = thirdMax(nums);
        System.out.println(thirdMax);
    }
    public static int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort (list);
        System.out.println(list);
        return (list.size() >= 3 ? list.get(list.size () - 3) : list.get(list.size () - 1));

    }
}

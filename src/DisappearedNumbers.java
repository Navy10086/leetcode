import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisappearedNumbers {
    public static void main(String[] args) {

    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        Arrays.sort (nums);
        List<Integer> list = new ArrayList<> ();
        int target = 1;
        for (int i = 0; i < len; i++){
            if (nums[i] != target){
                list.add ()
            }
        }
    }
}

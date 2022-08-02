import java.util.*;

public class ErrorNum {
    public static void main(String[] args) {
        int[] array = {1,2,3,3};
        int[] result = findErrorNums4 (array);
        System.out.println (Arrays.toString (result));
    }

    public static int[] findErrorNums4(int[] nums) {
        int[] result = new int[2];
        int len = nums.length;
        HashSet<Integer> set = new HashSet<> ();
        int beforeSum = 0;
        for (int num : nums) {
            beforeSum += num;
            set.add (num);
        }
        int sum = 0;
        for (Integer num : set) {
            sum += num;
        }
        result[0] = beforeSum - sum;
        result[1] = (1 + len) * len / 2 - sum;
        return result;
    }

    public static int[] findErrorNums3(int[] nums) {
        int[] result = new int[2];
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<> ();
        for (int num : nums) {
            map.put (num, map.getOrDefault (num,0) + 1);
        }

        for (int i = 1; i < len + 1; i++){
            Integer time = map.getOrDefault (i, 0);
            if (time == 0){
                result[1] = i;
            } else if (time == 2) {
                result[0] = i;
            }
        }
        return result;
    }

    public static int[] findErrorNums2(int[] nums) {
        int[] result = new int[2];
        int len = nums.length;
        Arrays.sort (nums);
        int preNum = 0;
        int currentNum = 0;
        for (int i = 0; i < len; i++){
            preNum = currentNum;
            currentNum = nums[i];
            if (preNum == currentNum){
                result[0] = preNum;
            }else if(currentNum - preNum == 2){
                result[1] = preNum + 1;
            }
        }
        if (nums[len -1] != len){
            result[1] = len;
        }
        return result;
    }

    public static int[] findErrorNums1(int[] nums) {
        int[] result = new int[2];
        int len = nums.length;
        Set<Integer> set = new HashSet<> ();
        for (int num : nums) {
            boolean add = set.add (num);
            if (!add){
                result[0] = num;
            }
        }
        ArrayList<Integer> list = new ArrayList<> (set);
        Collections.sort (list);
        int listSize = list.size ();
        for (int i = 0; i < len; i++){
            if (i < listSize && list.get (i) != i + 1){
                result[1] = i + 1;
                break;
            } else if (i == listSize -1){
                result[1] = i + 2;
            }
        }
        return result;
    }
}

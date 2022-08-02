import java.util.*;

public class ShortestSubArray {
    public static void main(String[] args) {
        int[] array = {47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,47,47,64,47,65,47,47,47,47,70,47,47,55,47,15,60,47,47,47,47,47,46,30,58,59,47,47,47,47,47,90,64,37,20,47,100,84,47,47,47,47,47,89,47,36,47,60,47,18,47,34,47,47,47,47,47,22,47,54,30,11,47,47,86,47,55,40,49,34,19,67,16,47,36,47,41,19,80,47,47,27};
        int num = findShortestSubArray2 (array);
        System.out.println (num);

    }

    public static int findShortestSubArray2(int[] nums) {
        int len = nums.length;
        HashMap<Integer, int[]> map = new HashMap<> ();
        for (int i = 0; i < len; i++){
            if (map.containsKey(nums[i])){
                int[] info = map.get (nums[i]);
                info[0] += 1;
                info[2] = i;
                map.put (nums[i], info);
            } else {
                map.put (nums[i], new int[]{1,i,i});
            }
        }
        int maxNum = 0;
        int minLen = 0;
        Set<Map.Entry<Integer, int[]>> entrySet = map.entrySet ();
        for (Map.Entry<Integer, int[]> entry : entrySet) {
            int[] valueArray = entry.getValue ();
            if (valueArray[0] > maxNum){
                maxNum = valueArray[0];
                minLen = valueArray[2] - valueArray[1] + 1;
            } else if(valueArray[0] == maxNum && (valueArray[2] - valueArray[1] + 1) < minLen){
                minLen = valueArray[2] - valueArray[1] + 1;
            }
        }
        return minLen;

    }

    public static int findShortestSubArray1(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<> ();
        for (int num : nums) {
            map.put (num,map.getOrDefault(num,0) + 1);
        }
        Set<Integer> keySet = map.keySet ();
        if (keySet.size () == len){
            return 1;
        }
        int maxTime = 0;
        for (Integer key : keySet) {
            if (map.get (key) > maxTime){
                maxTime = map.get (key);
            }
        }
        List<Integer> list = new ArrayList<> ();
        for (Integer key : keySet) {
            if (map.get (key) == maxTime){
               list.add (key);
            }
        }
        int minLen = len;
        for (Integer num : list) {
            int minNo = 0;
            int maxNo = 0;
            boolean isMin = true;
            for (int i = 0; i < len; i++){
                if (nums[i] == num){
                    if (isMin){
                        minNo = i;
                        maxNo = i;
                        isMin = false;
                    } else {
                        maxNo = i;
                    }

                }
            }
            int lenth = maxNo - minNo + 1;
            if (lenth < minLen) {
                minLen = lenth;
            }
        }
        return minLen;
    }
}

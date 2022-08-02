public class BinArrayMaxLen {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes2(nums);
        System.out.println(maxConsecutiveOnes);
    }

    public static int findMaxConsecutiveOnes1(int[] nums) {
        String str = "";
        for (int i = 0; i < nums.length; i++){
            str += nums[i];
        }
        String[] strings = str.split("0");
        int max = 0;
        for (String string : strings) {
            if (string.length() > max){
                max = string.length();
            }
        }
        return max;
    }

    public static int findMaxConsecutiveOnes2(int[] nums) {
        int maxCount = 0;
        int count = 0;
        int len = nums.length;
        for (int i = 0 ; i < nums.length; i++){
            if (nums[i] == 1){
                count++;
            } else {
                maxCount = Math.max(maxCount,count);
                count = 0;
            }
        }
        //最后一个元素，比较maxCount 与count;
        maxCount = Math.max(maxCount,count);
        return maxCount;
    }
}

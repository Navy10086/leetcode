public class PoisonedDuration {
    public static void main(String[] args) {
        int[] timeSeries = {1,4};
        int duration = 2;
        int poisonedDuration = findPoisonedDuration2(timeSeries, 2);
        System.out.println(poisonedDuration);
    }

    public static int findPoisonedDuration1(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        int totalDuration = 0;
        for(int i = 0; i < len; i++){
            if (i + 1 < len && timeSeries[i+1] - timeSeries[i] < duration){
                totalDuration += timeSeries[i+1] - timeSeries[i];
            } else {
                totalDuration += duration;
            }
        }
        return totalDuration;
    }

    public static int findPoisonedDuration2(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        int totalDuration = 0;
        int expire = 0;
        for(int i = 0; i < len; i++){
            if (timeSeries[i] >= expire){
                totalDuration += duration;
            } else {
                totalDuration += timeSeries[i] + duration - expire;
            }
            expire = timeSeries[i] + duration;
        }
        return totalDuration;
    }
}

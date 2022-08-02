import java.util.HashMap;

class WordFilter {

    String[] words = null;

    public WordFilter(String[] words) {
        this.words = words;
    }

    public int f(String pref, String suff) {
        HashMap<Integer, String> prefMap = new HashMap<>();
        HashMap<Integer, String> suffMap = new HashMap<>();
        int preLen = pref.length();
        int suffLen = suff.length();
        for (int i = 0; i < words.length; i++){
            String preString = words[i].substring(0,preLen);
            prefMap.put(i,preString);
            String suffString = words[i].substring(words[i].length() - suffLen) ;
            suffMap.put(i,suffString);
        }
        for (int i = words.length -1; i >= 0; i--){
            String preString = prefMap.get(i);
            String suffString = suffMap.get(i);
            if (pref.equals(preString) && suff.equals(suffString)){
                return i;
            }
        }
        return -1;
    }
}

import java.util.HashMap;

public class Dictionary {
    public static void main(String[] args) {
        String words[] = {"banana", "ape", "apple", "banana"};
        WordFilter wordFilter = new WordFilter(words);
        int index = wordFilter.f("a", "e");
        System.out.println(index);
    }

}

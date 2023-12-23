import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(nextBase(15, 8, "2"));
        System.out.println(nextBase(25, 2, "1111011"));
        System.out.println(nextBase(20, 12, "9AB"));
        System.out.println(nextBase(10, 16, "ABCDEF"));
        System.out.println(nextBase(1000, 2, "1"));

        //67 base 8 to base 7
        int sBase = 8;
        String original = "67";
        int dBase = 7;
        System.out.println(Integer.toString(Integer.parseInt(original, sBase), dBase));
    }

    public static int nextBase(int n, int b, String s) {

        if (n == 0)
            return n;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String current = Integer.toString(Integer.parseInt(s, b) + i, b);
            for (char c : current.toCharArray())
                if (map.containsKey(c))
                    map.replace(c, map.get(c) + 1);
                else
                    map.put(c, 1);
        }
        int isFirst = 0;
        int max;
        List<Integer> set = new ArrayList(map.values());
        Collections.sort(set);
        return set.get(set.size() - 1);
    }
}
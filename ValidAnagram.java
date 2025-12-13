import java.util.HashMap;

public class ValidAnagram {
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        int[] counts = new int[26];
//
//        for (int i = 0; i < s.length(); i++) {
//            counts[s.charAt(i) - 'a']++;
//            counts[t.charAt(i) - 'a']--;
//        }
//
//        for (int count : counts) {
//            if (count != 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    // --- Main Method for Demonstration ---

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character,Integer> ourHashMap = new HashMap<Character,Integer>();

        for (int i = 0; i < s.length(); i++) {
            ourHashMap.put(s.charAt(i), ourHashMap.getOrDefault(s.charAt(i),0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if(!ourHashMap.containsKey(t.charAt(i))){
                return false;
            }
            ourHashMap.put(t.charAt(i), ourHashMap.get(t.charAt(i)) - 1);

            if(ourHashMap.get(t.charAt(i)) == 0)
            {
                ourHashMap.remove(t.charAt(i));
            }
        }

        return ourHashMap.isEmpty();

    }

    public static void main(String[] args) {
        ValidAnagram solver = new ValidAnagram();

        // Example 1: Anagrams
        String s1 = "anagram";
        String t1 = "nagaram";
        boolean result1 = solver.isAnagram(s1, t1);
        System.out.println("--- Example 1 ---");
        System.out.println("s: \"" + s1 + "\", t: \"" + t1 + "\"");
        System.out.println("Result: " + result1 + " (Expected: true)");

        System.out.println("-----------------");

        // Example 2: Not Anagrams (different character counts)
        String s2 = "rat";
        String t2 = "car";
        boolean result2 = solver.isAnagram(s2, t2);
        System.out.println("--- Example 2 ---");
        System.out.println("s: \"" + s2 + "\", t: \"" + t2 + "\"");
        System.out.println("Result: " + result2 + " (Expected: false)");

        System.out.println("-----------------");

        // Example 3: Different lengths
        String s3 = "a";
        String t3 = "ab";
        boolean result3 = solver.isAnagram(s3, t3);
        System.out.println("--- Example 3 ---");
        System.out.println("s: \"" + s3 + "\", t: \"" + t3 + "\"");
        System.out.println("Result: " + result3 + " (Expected: false)");
    }
}

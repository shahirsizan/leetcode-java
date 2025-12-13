import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> ourHashSet = new HashSet<>();

        for (int num : nums) {
            if (ourHashSet.contains(num)) {
                return true;
            }
            ourHashSet.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
       boolean result= ContainsDuplicate.containsDuplicate(new int[]{1,2,3,4});
       System.out.println(result);
    }
}

import java.util.HashMap;

public class ContainsDuplicate2 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer, Integer> ourHashMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int currentNum = nums[i];

                if (ourHashMap.containsKey(currentNum)) {
                    int previousIndex = ourHashMap.get(currentNum);

                    if (Math.abs(i - previousIndex) <= k) {
                        return true;
                    }
                }

                ourHashMap.put(currentNum, i);
            }

            return false;
        }


        public static void main(String[] args) {
            ContainsDuplicate2 solver = new ContainsDuplicate2();

            // Example 1: True (2 is at index 0 and 3, distance |3-0|=3 which is <= k=3)
            int[] nums1 = {1, 2, 3, 1};
            int k1 = 3;
            boolean result1 = solver.containsNearbyDuplicate(nums1, k1);
            System.out.println("--- Example 1 ---");
            System.out.println("Nums: " + java.util.Arrays.toString(nums1) + ", k: " + k1);
            System.out.println("Result: " + result1 + " (Expected: true)");

            System.out.println("-----------------");

            // Example 2: True (1 is at index 0 and 2, distance |2-0|=2 which is <= k=2)
            int[] nums2 = {1, 0, 1, 1};
            int k2 = 2;
            boolean result2 = solver.containsNearbyDuplicate(nums2, k2);
            System.out.println("--- Example 2 ---");
            System.out.println("Nums: " + java.util.Arrays.toString(nums2) + ", k: " + k2);
            System.out.println("Result: " + result2 + " (Expected: true)");

            System.out.println("-----------------");

            // Example 3: False (All duplicates are farther than k=1)
            int[] nums3 = {1, 2, 3, 1, 2, 3};
            int k3 = 2;
            boolean result3 = solver.containsNearbyDuplicate(nums3, k3);
            System.out.println("--- Example 3 ---");
            System.out.println("Nums: " + java.util.Arrays.toString(nums3) + ", k: " + k3);
            System.out.println("Result: " + result3 + " (Expected: false)");
        }


}

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSumSolution {


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> Mapp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];

            if (Mapp.containsKey(remaining)) {
                return new int[] {i, Mapp.get(remaining)};
            }
            else{
                Mapp.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No two sum solution found for the given input.");
    }


    public static void main(String[] args) {
        TwoSumSolution solver = new TwoSumSolution();

        // Example 1: Solution exists
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        System.out.println("--- Example 1 ---");
        System.out.println("Array: " + Arrays.toString(nums1) + ", Target: " + target1);
        try {
            int[] result1 = solver.twoSum(nums1, target1);
            System.out.println("Indices: " + Arrays.toString(result1)); // Expected: [0, 1]
            System.out.println("Check: " + nums1[result1[0]] + " + " + nums1[result1[1]] + " = 9");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Example 2: Different array and target
        int[] nums2 = {3, 2, 4};
        int target2 = 6;

        System.out.println("\n--- Example 2 ---");
        System.out.println("Array: " + Arrays.toString(nums2) + ", Target: " + target2);
        try {
            int[] result2 = solver.twoSum(nums2, target2);
            System.out.println("Indices: " + Arrays.toString(result2)); // Expected: [1, 2]
            System.out.println("Check: " + nums2[result2[0]] + " + " + nums2[result2[1]] + " = 6");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
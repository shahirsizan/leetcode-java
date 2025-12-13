import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> ourHashMap = new HashMap<>();
//		  populate the hashmap
        for (int num : nums) {
            ourHashMap.put(num, ourHashMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : ourHashMap.entrySet()) {
			   minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(minHeap.poll()).getKey();
        }

        return result;
    }

    // --- Main Method for Demonstration ---

    public static void main(String[] args) {
        TopKFrequentElements solver = new TopKFrequentElements();

        // Example 1:
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = solver.topKFrequent(nums1, k1);
        // Expected: [1, 2] (order may vary)
        System.out.println("--- Example 1 ---");
        System.out.println("Input: " + Arrays.toString(nums1) + ", k: " + k1);
        System.out.println("Result: " + Arrays.toString(result1));

        System.out.println("-----------------");

        // Example 2:
        int[] nums2 = {4, 1, -1, 2, -1, 2, 3};
        int k2 = 2;
        int[] result2 = solver.topKFrequent(nums2, k2);
        // Frequencies: 1:1, -1:2, 2:2, 3:1. Top 2 are -1 and 2.
        System.out.println("--- Example 2 ---");
        System.out.println("Input: " + Arrays.toString(nums2) + ", k: " + k2);
        System.out.println("Result: " + Arrays.toString(result2));
    }
}

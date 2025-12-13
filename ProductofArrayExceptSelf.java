import java.util.Arrays;

public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int arrayLength = nums.length;
        int[] answerArray = new int[arrayLength];

        int prefixProduct = 1;
        for (int i = 0; i < arrayLength; i++) {
            answerArray[i] = prefixProduct;
            // update prefix product
            prefixProduct = prefixProduct * nums[i];
        }

        int suffixProduct = 1;
        for (int i = arrayLength - 1; i >= 0; i--) {
            answerArray[i] = answerArray[i] * suffixProduct;
            // update suffix product
            suffixProduct = suffixProduct * nums[i];
        }

        return answerArray;
    }


    public static void main(String[] args) {
        ProductofArrayExceptSelf solver = new ProductofArrayExceptSelf();

        // Example 1:
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solver.productExceptSelf(nums1);
        // Expected: [2*3*4, 1*3*4, 1*2*4, 1*2*3] = [24, 12, 8, 6]
        System.out.println("--- Example 1 ---");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Result: " + Arrays.toString(result1));

        System.out.println("-----------------");

        // Example 2: Includes zeros (must handle correctly without division)
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solver.productExceptSelf(nums2);
        // Expected: [0, 0, 9, 0, 0]
        System.out.println("--- Example 2 ---");
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Result: " + Arrays.toString(result2));
    }
}
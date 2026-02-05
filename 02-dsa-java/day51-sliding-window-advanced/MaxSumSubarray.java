public class MaxSumSubarray {

    public static int maxSum(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[i - (k - 1)];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{2,1,5,1,3,2}, 3));
    }
}

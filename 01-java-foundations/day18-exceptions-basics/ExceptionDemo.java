public class ExceptionDemo {
    public static void main(String[] args) {

        try {
            int[] nums = {1, 2, 3};
            System.out.println(nums[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of range");
        } finally {
            System.out.println("Execution finished");
        }
    }
}

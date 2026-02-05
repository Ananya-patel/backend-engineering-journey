import java.util.HashMap;
import java.util.Map;
public class TwoSum{
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int needed=target-nums[i];
            if(map.containsKey(needed)){
                return new int[]{map.get(needed),i};

            }
            map.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(result[0] + ", " + result[1]);
    }
    
}
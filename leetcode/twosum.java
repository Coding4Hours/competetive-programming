import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        return twoSumHelper(nums, target, 0, new HashMap<>());
    }
    
    private int[] twoSumHelper(int[] nums, int target, int index, Map<Integer, Integer> map) {
        if (index >= nums.length) {
            return new int[] {};
        }
        
        int complement = target - nums[index];
        if (map.containsKey(complement)) {
            return new int[] {map.get(complement), index};
        }
        
        map.put(nums[index], index);
        return twoSumHelper(nums, target, index + 1, map);
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int result = 0;
        if (target < nums[0]){
            result = 0;
        }else if(target > nums[length-1]){
            result = length;
        }else{
            for(int i = 0; i < length;i++){
                if(target == nums[i]){
                    result = i;
                    break;
                }else if(target < nums[i]){
                    result = i;
                    break;
                }
            }
        }
        return result;

    }
}
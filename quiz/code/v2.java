class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        System.out.println(nums[0]);
        int count = 0;
        int result = nums[0];
        int num = nums[0];
        int temp_count = 0;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] == num){
                temp_count++;
            }else{
                if (temp_count > nums.length / 2){
                    count = temp_count;
                    result = num;
                }
                temp_count = 1;
                num = nums[i];
            }
        }
        return result;
    }
}
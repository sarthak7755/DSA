class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int max=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }

        int fq[]=new int[max+1];

        for(int i=0;i<nums.length;i++){
            fq[nums[i]]++;
        }

        for(int i=0;i<fq.length;i++){
            if(fq[i]>2){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean stoneGame(int[] nums) { 
        //nums -> piles
        int n=nums.length;
        int i=0;
        int j=n-1;
        int alice=0;
        int bob=0;
        int flag=1;
        while(i <= j){
            if(flag==1)
            {
                if(nums[i] > nums[j])
                {
                    alice += nums[i];
                    i++;
                }
                    
                else
                {
                    alice += nums[j];
                    j--;
                }
                    
            }
            else{
                if(nums[i] > nums[j])
                {
                    bob += nums[j];
                    j--;
                }
                else{
                    bob += nums[i];
                    i++;
                }
                    
            }
            flag ^= 1;
        }
        return alice >= bob;
    }
}
//shrutink
class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n=nums.length;
        int[] arr=new int[2*n];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
            arr[i+n]=nums[n-1-i];
        }
        return arr;
    }
}
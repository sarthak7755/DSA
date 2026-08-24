class Solution {
    public int stoneGameVIII(int[] stones) {
        int n =stones.length;
        int[] pref =new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += stones[i];
            pref[i] = sum;
        }
        int prev = pref[n-1];
        // dp[n-1] = pref[n-1];
        for(int i=n-2;i>=1;i--){
            int take = pref[i]-prev;
            int skip = prev;
            prev = Math.max(take,skip);
        }
        return prev;
    }
    // public int memo(int i,int[] pref,Integer[] dp,int n){
    //     if(i==n-1) return pref[n-1];
    //     if(dp[i]!=null) return dp[i];
    //     int take = pref[i]-memo(i+1,pref,dp,n);
    //     int skip = memo(i+1,pref,dp,n);
    //     return dp[i]=Math.max(take,skip);
    // }
}
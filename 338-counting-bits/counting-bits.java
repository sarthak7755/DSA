public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        for(int i=1;i<=num;i++){
            if(i%2!=0) result[i] = result[i-1]+1;
            else if(1073741824%i==0) result[i] = 1;
            else result[i] = result[i/2];
        }
        return result;
    }
}
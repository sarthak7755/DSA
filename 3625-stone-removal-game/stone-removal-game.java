class Solution {
    public boolean canAliceWin(int n) {
        int b = 1;
        int k = 10;
        while (n >= k) {
            b *= -1;
            n -= k;
            k -= 1;
        }
        if (b == -1)
            return true;
        return false;
    }
}
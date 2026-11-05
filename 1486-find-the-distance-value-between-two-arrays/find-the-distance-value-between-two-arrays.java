class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        boolean[] blocked = new boolean[2001];

        // Mark every value within distance d of each arr2 element.
        for (int b : arr2) {
            int start = Math.max(0, b + 1000 - d);
            int end = Math.min(2000, b + 1000 + d);

            for (int i = start; i <= end; i++) {
                blocked[i] = true;
            }
        }

        int ans = 0;

        // Count arr1 elements that are not blocked.
        for (int a : arr1) {
            if (!blocked[a + 1000]) ans++;
        }

        return ans;
    }
}
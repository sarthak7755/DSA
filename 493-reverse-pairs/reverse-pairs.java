class Solution {
    public int reversePairs(int[] nums) {
        int[] tmp = new int[nums.length];
        return mergeSort(nums, tmp, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] tmp, int lo, int hi) {
        if (lo >= hi) return 0;

        int mid = lo + (hi - lo) / 2;

        int count = mergeSort(nums, tmp, lo, mid)
                  + mergeSort(nums, tmp, mid + 1, hi);

        int j = mid + 1;

        for (int i = lo; i <= mid; i++) {
            while (j <= hi && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        int i = lo, k = lo;
        j = mid + 1;

        while (i <= mid && j <= hi) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }

        while (j <= hi) {
            tmp[k++] = nums[j++];
        }

        for (int p = lo; p <= hi; p++) {
            nums[p] = tmp[p];
        }

        return count;
    }
}
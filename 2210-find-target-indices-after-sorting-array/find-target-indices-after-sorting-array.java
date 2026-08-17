class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        List<Integer> arr = new ArrayList<>();
        if (index == -1)
            return arr;
        int i = index;
        while (i >= 0 && nums[i] == target)
            arr.add(0, i--);
        i = index + 1;
        while (i < n && nums[i] == target)
            arr.add(i++);
        return arr;
    }
}
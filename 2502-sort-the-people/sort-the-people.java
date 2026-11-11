class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i<heights.length; i++)
        {
            map.put(heights[i], names[i]);
        }
        String ans[] = new String[names.length];
        Arrays.sort(heights);
        int index = 0;
        for(int i = heights.length-1; i>-1; i--)
        {
            ans[i] = map.get(heights[index++]);
        }
    return ans;
    }
}
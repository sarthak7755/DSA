class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] ans = new String[arr.length];
        for (String i : arr)
            ans[i.charAt(i.length() - 1) - '0' - 1] = i;
        StringBuilder sb = new StringBuilder();
        for (String i : ans)
            sb.append(i.substring(0, i.length() - 1) + " ");
        return sb.substring(0, sb.length() - 1).toString();
    }
}
class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int[] lps = computeLPS(word.toCharArray());
        int suffix = lps[n - 1]; // longest border length

        // Try borders from longest to shorter until divisible condition holds
        while (suffix > 0 && (n - suffix) % k != 0) {
            suffix = lps[suffix - 1];
        }

        // If a valid border works, minimal t = (n - suffix)/k
        if ((n - suffix) % k == 0) {
            return (n - suffix) / k;
        }

        // Otherwise, delete the whole string in chunks of k
        return (n + k - 1) / k; // ceil(n/k)
    }

    // Standard KMP LPS computation
    private int[] computeLPS(char[] s) {
        int n = s.length;
        int[] lps = new int[n];
        int len = 0; // current length of matched prefix-suffix
        int i = 1;

        while (i < n) {
            if (s[i] == s[len]) {
                lps[i] = ++len;
                i++;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}